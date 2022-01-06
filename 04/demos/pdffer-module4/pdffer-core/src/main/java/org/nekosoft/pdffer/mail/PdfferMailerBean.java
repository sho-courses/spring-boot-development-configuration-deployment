package org.nekosoft.pdffer.mail;

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

@Component
@ConditionalOnClass(name = "org.springframework.mail.javamail.JavaMailSender")
public class PdfferMailerBean {

    private final JavaMailSender mailSender;

    private String sendFromName = "PDFfer";
    private String sendFromAddress = "pdf@pdffer.domain";
    private String replyToName = "PDFfer Admin";
    private String replyToAddress = "admin@pdffer.domain";

    public PdfferMailerBean(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessageWithPdfAttachment(List<InternetAddress> to, String subject, String text, byte[] attachment, String filename, String sendFrom, String replyTo) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            if (sendFrom != null) {
                helper.setFrom(sendFrom);
            } else {
                helper.setFrom(String.format("\"%s\" <%s>", sendFromName, sendFromAddress));
            }
            if (replyTo != null) {
                helper.setReplyTo(replyTo);
            } else {
                helper.setReplyTo(String.format("\"%s\" <%s>", replyToName, replyToAddress));
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

    public void sendMessageWithPdfAttachment(String toString, String subject, String text, byte[] attachment, String filename, String sendFrom, String replyTo) {
        sendMessageWithPdfAttachmentToList(Arrays.asList(toString.split(",")), subject, text, attachment, filename, sendFrom, replyTo);
    }

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
