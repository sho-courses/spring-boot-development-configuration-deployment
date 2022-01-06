package org.nekosoft.pdffer.actuator;

import org.nekosoft.pdffer.props.PdfferMailerControllerProps;
import org.nekosoft.pdffer.props.PdfferWebControllerProps;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="pdfferWebControllerProps")
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@Profile("!pdffer-no-actuator & !pdffer-shell")
public class WebControllerInfoEndpoint {
	private final PdfferWebControllerProps webControllerProps;

	public WebControllerInfoEndpoint(PdfferWebControllerProps webControllerProps) {
		this.webControllerProps = webControllerProps;
	}
	
	@ReadOperation
    public PdfferWebControllerProps props() {
        return webControllerProps;
    }
	
}
