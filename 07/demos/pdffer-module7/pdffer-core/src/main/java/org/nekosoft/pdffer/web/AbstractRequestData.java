package org.nekosoft.pdffer.web;

import java.util.Map;

/**
 * The type Abstract request data.
 */
public abstract class AbstractRequestData {
	private Map<String, Object> payload;

    /**
     * Gets payload.
     *
     * @return the payload
     */
    public Map<String, Object> getPayload() {
		return payload;
	}

    /**
     * Sets payload.
     *
     * @param payload the payload
     */
    public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
}
