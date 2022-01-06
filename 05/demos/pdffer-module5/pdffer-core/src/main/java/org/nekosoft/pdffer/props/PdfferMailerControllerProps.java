package org.nekosoft.pdffer.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "pdffer.mailer.controller")
@ConstructorBinding
public class PdfferMailerControllerProps {
    // field declarations
    String baseUri;
    String mailUri;

    public PdfferMailerControllerProps(String baseUri, String mailUri) {
        // set field values
        this.baseUri = baseUri;
        this.mailUri = mailUri;
    }

    // getters only

    public String getBaseUri() {
        return baseUri;
    }

    public String getMailUri() {
        return mailUri;
    }

}
