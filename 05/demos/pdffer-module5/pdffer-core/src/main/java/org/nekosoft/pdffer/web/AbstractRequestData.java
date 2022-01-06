package org.nekosoft.pdffer.web;

import java.util.Map;

public abstract class AbstractRequestData {
	private Map<String, Object> payload;
	
	public Map<String, Object> getPayload() {
		return payload;
	}
	
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
}
