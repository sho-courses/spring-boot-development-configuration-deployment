package org.nekosoft.pdffer.web;

public class DownloadRequestData extends AbstractRequestData {
	private String filename;
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
