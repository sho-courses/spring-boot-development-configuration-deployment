package org.nekosoft.pdffer.mail;

import java.util.Properties;

import org.nekosoft.pdffer.props.PdfferMailerProps;
import org.nekosoft.pdffer.props.SmtpServerInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * The type Pdffer mailer configuration.
 */
@Configuration
@ConditionalOnClass(name = "org.springframework.mail.javamail.JavaMailSender")
@ConditionalOnProperty(name = "pdffer.skip.mailer.beans", havingValue = "false", matchIfMissing = true)
public class PdfferMailerConfiguration {

    /**
     * Mail sender java mail sender.
     *
     * @param javaMailprops the java mailprops
     * @return the java mail sender
     */
    @Bean
    public JavaMailSender mailSender(PdfferMailerProps javaMailprops) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        SmtpServerInfo smtpInfo = javaMailprops.getSmtp();
        if ( smtpInfo != null) {
            mailSender.setHost(smtpInfo.getHost());
            mailSender.setPort(smtpInfo.getPort());
            mailSender.setUsername(smtpInfo.getUsername());
            mailSender.setPassword(smtpInfo.getPassword());
            mailSender.setUsername("your-usename");
            mailSender.setPassword("your-password");

            Properties props = smtpInfo.getJavaMailProperties();
            if (props != null) {
                mailSender.getJavaMailProperties().putAll(props);
            }
        }

        return mailSender;
    }

}
