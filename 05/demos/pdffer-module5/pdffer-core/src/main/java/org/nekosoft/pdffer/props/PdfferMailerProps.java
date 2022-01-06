package org.nekosoft.pdffer.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

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

    public PdfferMailerProps(EmailAddressInfo sendFrom, EmailAddressInfo replyTo, SmtpServerInfo smtp) {
        // set field values
        this.sendFrom = sendFrom;
        this.replyTo = replyTo;
        this.smtp = smtp;
    }

    // getters only

    public EmailAddressInfo getSendFrom() {
        return sendFrom;
    }

    public EmailAddressInfo getReplyTo() {
        return replyTo;
    }

    public SmtpServerInfo getSmtp() {
        return smtp;
    }

}
