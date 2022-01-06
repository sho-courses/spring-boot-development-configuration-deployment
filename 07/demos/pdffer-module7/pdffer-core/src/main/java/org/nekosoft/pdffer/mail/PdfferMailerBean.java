package org.nekosoft.pdffer.mail;

import org.nekosoft.pdffer.props.PdfferMailerProps;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Pdffer mailer bean.
 */
@Component
@ConditionalOnClass(name = "org.springframework.mail.javamail.JavaMailSender")
@ConditionalOnProperty(name = "pdffer.skip.mailer.beans", havingValue = "false", matchIfMissing = true)
public class PdfferMailerBean {

    private final JavaMailSender mailSender;

    private PdfferMailerProps props;

    /**
     * Instantiates a new Pdffer mailer bean.
     *
     * @param mailSender the mail sender
     * @param props      the props
     */
    public PdfferMailerBean(JavaMailSender mailSender, PdfferMailerProps props) {
        this.mailSender = mailSender;
        this.props = props;
    }

    /**
     * Send message with pdf attachment.
     *
     * @param to         the to
     * @param subject    the subject
     * @param text       the text
     * @param attachment the attachment
     * @param filename   the filename
     * @param sendFrom   the send from
     * @param replyTo    the reply to
     * @throws MessagingException the messaging exception
     */
    public void sendMessageWithPdfAttachment(List<InternetAddress> to, String subject, String text, byte[] attachment, String filename, String sendFrom, String replyTo) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            if (sendFrom != null) {
                helper.setFrom(sendFrom);
            } else {
                helper.setFrom(String.format("\"%s\" <%s>", props.getSendFrom().getName(), props.getSendFrom().getAddress()));
            }
            if (replyTo != null) {
                helper.setReplyTo(replyTo);
            } else {
                helper.setReplyTo(String.format("\"%s\" <%s>", props.getReplyTo().getName(), props.getReplyTo().getAddress()));
            }
            helper.setTo(to.toArray(new InternetAddress[] {}));
            helper.setSubject(subject);
            helper.setText(text);

            helper.addAttachment(filename, new ByteArrayResource(attachment), MediaType.APPLICATION_PDF_VALUE);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Send message with pdf attachment.
     *
     * @param toString   the to string
     * @param subject    the subject
     * @param text       the text
     * @param attachment the attachment
     * @param filename   the filename
     * @param sendFrom   the send from
     * @param replyTo    the reply to
     */
    public void sendMessageWithPdfAttachment(String toString, String subject, String text, byte[] attachment, String filename, String sendFrom, String replyTo) {
        sendMessageWithPdfAttachmentToList(Arrays.asList(toString.split(",")), subject, text, attachment, filename, sendFrom, replyTo);
    }

    /**
     * Send message with pdf attachment to list.
     *
     * @param toList     the to list
     * @param subject    the subject
     * @param text       the text
     * @param attachment the attachment
     * @param filename   the filename
     * @param sendFrom   the send from
     * @param replyTo    the reply to
     */
    public void sendMessageWithPdfAttachmentToList(List<String> toList, String subject, String text, byte[] attachment, String filename, String sendFrom, String replyTo) {
        try {
            List<InternetAddress> recipients = new ArrayList<>();
            for (String email : toList) {
                recipients.add(new InternetAddress(email));
            }
            sendMessageWithPdfAttachment(recipients, subject, text, attachment, filename, sendFrom, replyTo);
        } catch (MessagingException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
