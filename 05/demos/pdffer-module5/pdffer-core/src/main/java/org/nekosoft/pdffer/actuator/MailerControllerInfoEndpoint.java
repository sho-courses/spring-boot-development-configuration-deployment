package org.nekosoft.pdffer.actuator;

import org.nekosoft.pdffer.props.PdfferMailerControllerProps;
import org.nekosoft.pdffer.props.PdfferWebControllerProps;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="pdfferMailerControllerProps")
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@Profile("!pdffer-no-actuator & !pdffer-shell")
public class MailerControllerInfoEndpoint {
	private final PdfferMailerControllerProps mailerControllerProps;

	public MailerControllerInfoEndpoint(PdfferMailerControllerProps mailerControllerProps) {
		this.mailerControllerProps = mailerControllerProps;
	}
	
	@ReadOperation
    public PdfferMailerControllerProps props() {
        return mailerControllerProps;
    }
	
}
