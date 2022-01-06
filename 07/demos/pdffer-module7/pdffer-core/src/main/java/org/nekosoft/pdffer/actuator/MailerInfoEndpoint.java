package org.nekosoft.pdffer.actuator;

import org.nekosoft.pdffer.props.PdfferMailerProps;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * The type Mailer info endpoint.
 */
@Component
@Endpoint(id="pdfferMailerProps")
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@Profile("pdffer-actuator")
public class MailerInfoEndpoint {
	private PdfferMailerProps mailerProps;

    /**
     * Instantiates a new Mailer info endpoint.
     *
     * @param mailerProps the mailer props
     */
    public MailerInfoEndpoint(PdfferMailerProps mailerProps) {
		this.mailerProps = mailerProps;
	}

    /**
     * Props pdffer mailer props.
     *
     * @return the pdffer mailer props
     */
    @ReadOperation
    public PdfferMailerProps props() {
        return mailerProps;
    }
	
}
