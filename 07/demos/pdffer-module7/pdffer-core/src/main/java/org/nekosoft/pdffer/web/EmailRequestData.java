package org.nekosoft.pdffer.web;

import java.util.List;

/**
 * The type Email request data.
 */
public class EmailRequestData extends AbstractRequestData {
	private List<String> emailTo;
	private String subject;
	private String message;
	private String filename;
	private String sendFrom;
	private String replyTo;

    /**
     * Gets email to.
     *
     * @return the email to
     */
    public List<String> getEmailTo() {
		return emailTo;
	}

    /**
     * Sets email to.
     *
     * @param emailTo the email to
     */
    public void setEmailTo(List<String> emailTo) {
		this.emailTo = emailTo;
	}

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
		return subject;
	}

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
		this.subject = subject;
	}

    /**
     * Gets filename.
     *
     * @return the filename
     */
    public String getFilename() {
		return filename;
	}

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
		return message;
	}

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
		this.message = message;
	}

    /**
     * Sets filename.
     *
     * @param filename the filename
     */
    public void setFilename(String filename) {
		this.filename = filename;
	}

    /**
     * Gets send from.
     *
     * @return the send from
     */
    public String getSendFrom() {
		return sendFrom;
	}

    /**
     * Sets send from.
     *
     * @param sendFrom the send from
     */
    public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}

    /**
     * Gets reply to.
     *
     * @return the reply to
     */
    public String getReplyTo() {
		return replyTo;
	}

    /**
     * Sets reply to.
     *
     * @param replyTo the reply to
     */
    public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
}
