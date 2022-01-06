package org.nekosoft.pdffer.web;

/**
 * The type Download request data.
 */
public class DownloadRequestData extends AbstractRequestData {
	private String filename;

    /**
     * Gets filename.
     *
     * @return the filename
     */
    public String getFilename() {
		return filename;
	}

    /**
     * Sets filename.
     *
     * @param filename the filename
     */
    public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
