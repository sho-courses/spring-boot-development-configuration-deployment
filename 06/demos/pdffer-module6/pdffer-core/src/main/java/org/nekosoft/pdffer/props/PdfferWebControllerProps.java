package org.nekosoft.pdffer.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "pdffer.web.controller")
@ConstructorBinding
public class PdfferWebControllerProps {
    // field declarations
    /** The base URL for the controller */
    String baseUri;
    /** The URL for the Download endpoint of the controller */
    String downloadUri;
    /** The URL for the Save endpoint of the controller */
    String saveUri;

    public PdfferWebControllerProps(String baseUri, String downloadUri, String saveUri) {
        // set field values
        this.baseUri = baseUri;
        this.downloadUri = downloadUri;
        this.saveUri = saveUri;
    }

    // getters and setters

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getDownloadUri() {
        return downloadUri;
    }

    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }

    public String getSaveUri() {
        return saveUri;
    }

    public void setSaveUri(String saveUri) {
        this.saveUri = saveUri;
    }

}
