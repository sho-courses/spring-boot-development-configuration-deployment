package org.nekosoft.pdffer.actuator;

import org.nekosoft.pdffer.props.PdfferMailerProps;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="pdfferMailerProps")
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@Profile("!pdffer-no-actuator & !pdffer-shell")
public class MailerInfoEndpoint {
	private PdfferMailerProps mailerProps;
	
	public MailerInfoEndpoint(PdfferMailerProps mailerProps) {
		this.mailerProps = mailerProps;
	}
	
	@ReadOperation
    public PdfferMailerProps props() {
        return mailerProps;
    }
	
}
