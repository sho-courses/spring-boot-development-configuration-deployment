package org.nekosoft.pdffer.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * The type Pdffer web controller props.
 */
@ConfigurationProperties(prefix = "pdffer.web.controller")
@ConstructorBinding
public class PdfferWebControllerProps {
    // field declarations
    /**
     * The base URL for the controller
     */
    String baseUri;
    /**
     * The URL for the Download endpoint of the controller
     */
    String downloadUri;
    /**
     * The URL for the Save endpoint of the controller
     */
    String saveUri;

    /**
     * Instantiates a new Pdffer web controller props.
     *
     * @param baseUri     the base uri
     * @param downloadUri the download uri
     * @param saveUri     the save uri
     */
    public PdfferWebControllerProps(String baseUri, String downloadUri, String saveUri) {
        // set field values
        this.baseUri = baseUri;
        this.downloadUri = downloadUri;
        this.saveUri = saveUri;
    }

    // getters and setters

    /**
     * Gets base uri.
     *
     * @return the base uri
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets base uri.
     *
     * @param baseUri the base uri
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * Gets download uri.
     *
     * @return the download uri
     */
    public String getDownloadUri() {
        return downloadUri;
    }

    /**
     * Sets download uri.
     *
     * @param downloadUri the download uri
     */
    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }

    /**
     * Gets save uri.
     *
     * @return the save uri
     */
    public String getSaveUri() {
        return saveUri;
    }

    /**
     * Sets save uri.
     *
     * @param saveUri the save uri
     */
    public void setSaveUri(String saveUri) {
        this.saveUri = saveUri;
    }

}
