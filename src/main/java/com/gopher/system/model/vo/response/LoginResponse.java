package com.gopher.system.model.vo.response;

public class LoginResponse {
	
	private String sessionKey;
	
	private long expiryTime;

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
	

}
