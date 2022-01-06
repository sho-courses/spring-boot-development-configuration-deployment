package org.nekosoft.pdffer.actuator;

import org.nekosoft.pdffer.props.PdfferWebControllerProps;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * The type Web controller info endpoint.
 */
@Component
@Endpoint(id="pdfferWebControllerProps")
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@Profile("pdffer-actuator")
public class WebControllerInfoEndpoint {
	private PdfferWebControllerProps webControllerProps;

    /**
     * Instantiates a new Web controller info endpoint.
     *
     * @param webControllerProps the mailer controller props
     */
    public WebControllerInfoEndpoint(PdfferWebControllerProps webControllerProps) {
		this.webControllerProps = webControllerProps;
	}

    /**
     * Props pdffer mailer controller props.
     *
     * @return the pdffer mailer controller props
     */
    @ReadOperation
    public PdfferWebControllerProps props() {
        return webControllerProps;
    }
	
}
