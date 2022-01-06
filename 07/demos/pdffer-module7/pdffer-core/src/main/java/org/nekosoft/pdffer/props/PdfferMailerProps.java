package org.nekosoft.pdffer.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * The type Pdffer mailer props.
 */
@ConfigurationProperties(prefix = "pdffer.mailer")
@ConstructorBinding
public class PdfferMailerProps {
    // field declarations
    /** The default email address that will be used as the sender for the emails sent by PDFfer */
    private EmailAddressInfo sendFrom;
    /** The default email address that will be used as the reply-to header for the emails sent by PDFfer */
    private EmailAddressInfo replyTo;
    /** The settings of the SMTP server that will be used to send email messages from PDFfer */
    private SmtpServerInfo smtp;

    /**
     * Instantiates a new Pdffer mailer props.
     *
     * @param sendFrom the send from
     * @param replyTo  the reply to
     * @param smtp     the smtp
     */
    public PdfferMailerProps(EmailAddressInfo sendFrom, EmailAddressInfo replyTo, SmtpServerInfo smtp) {
        // set field values
        this.sendFrom = sendFrom;
        this.replyTo = replyTo;
        this.smtp = smtp;
    }

    // getters only

    /**
     * Gets send from.
     *
     * @return the send from
     */
    public EmailAddressInfo getSendFrom() {
        return sendFrom;
    }

    /**
     * Gets reply to.
     *
     * @return the reply to
     */
    public EmailAddressInfo getReplyTo() {
        return replyTo;
    }

    /**
     * Gets smtp.
     *
     * @return the smtp
     */
    public SmtpServerInfo getSmtp() {
        return smtp;
    }

}
