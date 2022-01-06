package org.nekosoft.pdffer.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * The type Pdffer mailer controller props.
 */
@ConfigurationProperties(prefix = "pdffer.mailer.controller")
@ConstructorBinding
public class PdfferMailerControllerProps {
    /**
     * The Base uri.
     */
// field declarations
    String baseUri;
    /**
     * The Mail uri.
     */
    String mailUri;

    /**
     * Instantiates a new Pdffer mailer controller props.
     *
     * @param baseUri the base uri
     * @param mailUri the mail uri
     */
    public PdfferMailerControllerProps(String baseUri, String mailUri) {
        // set field values
        this.baseUri = baseUri;
        this.mailUri = mailUri;
    }

    // getters only

    /**
     * Gets base uri.
     *
     * @return the base uri
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Gets mail uri.
     *
     * @return the mail uri
     */
    public String getMailUri() {
        return mailUri;
    }

}
