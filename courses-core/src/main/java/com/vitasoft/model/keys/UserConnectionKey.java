package com.vitasoft.model.keys;

import java.io.Serializable;

public class UserConnectionKey implements Serializable {
	
	private String userId;
	private String providerId;
	private String providerUserId;
	
	public UserConnectionKey() {
	}
	
	public UserConnectionKey(String userId, String providerId, String providerUserId) {
		this.userId = userId;
		this.providerId = providerId;
		this.providerUserId = providerUserId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getProviderId() {
		return providerId;
	}
	
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
	public String getProviderUserId() {
		return providerUserId;
	}
	
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		UserConnectionKey that = (UserConnectionKey) o;
		
		if (userId != null ? !userId.equals(that.userId) : that.userId != null) {
			return false;
		}
		if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) {
			return false;
		}
		return providerUserId != null ? providerUserId.equals(that.providerUserId) : that.providerUserId == null;
	}
	
	@Override
	public int hashCode() {
		int result = userId != null ? userId.hashCode() : 0;
		result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
		result = 31 * result + (providerUserId != null ? providerUserId.hashCode() : 0);
		return result;
	}
}
