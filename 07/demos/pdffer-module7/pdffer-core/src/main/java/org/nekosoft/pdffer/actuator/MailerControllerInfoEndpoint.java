package org.nekosoft.pdffer.actuator;

import org.nekosoft.pdffer.props.PdfferMailerControllerProps;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * The type Mailer controller info endpoint.
 */
@Component
@Endpoint(id="pdfferMailerControllerProps")
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@Profile("pdffer-actuator")
public class MailerControllerInfoEndpoint {
	private final PdfferMailerControllerProps mailerControllerProps;

    /**
     * Instantiates a new Mailer controller info endpoint.
     *
     * @param mailerControllerProps the web controller props
     */
    public MailerControllerInfoEndpoint(PdfferMailerControllerProps mailerControllerProps) {
		this.mailerControllerProps = mailerControllerProps;
	}

    /**
     * Props pdffer web controller props.
     *
     * @return the pdffer web controller props
     */
    @ReadOperation
    public PdfferMailerControllerProps props() {
        return mailerControllerProps;
    }
	
}
