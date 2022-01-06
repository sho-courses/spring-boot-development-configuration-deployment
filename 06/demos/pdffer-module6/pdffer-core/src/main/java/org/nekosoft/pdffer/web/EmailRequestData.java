package org.nekosoft.pdffer.web;

import java.util.List;

public class EmailRequestData extends AbstractRequestData {
	private List<String> emailTo;
	private String subject;
	private String message;
	private String filename;
	private String sendFrom;
	private String replyTo;

	public List<String> getEmailTo() {
		return emailTo;
	}
	
	public void setEmailTo(List<String> emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSendFrom() {
		return sendFrom;
	}

	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
}
