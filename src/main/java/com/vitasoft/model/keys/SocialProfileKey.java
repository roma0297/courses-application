package com.vitasoft.model.keys;

import com.vitasoft.enums.SocialLoginProvider;
import java.io.Serializable;

public class SocialProfileKey implements Serializable {
	
	private String userId;
	private SocialLoginProvider socialLoginProvider;
	
	public SocialProfileKey() {
	}
	
	public SocialProfileKey(String userId, SocialLoginProvider socialLoginProvider) {
		this.userId = userId;
		this.socialLoginProvider = socialLoginProvider;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public SocialLoginProvider getSocialLoginProvider() {
		return socialLoginProvider;
	}
	
	public void setSocialLoginProvider(SocialLoginProvider socialLoginProvider) {
		this.socialLoginProvider = socialLoginProvider;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		SocialProfileKey that = (SocialProfileKey) o;
		
		if (userId != null ? !userId.equals(that.userId) : that.userId != null) {
			return false;
		}
		return socialLoginProvider == that.socialLoginProvider;
	}
	
	@Override
	public int hashCode() {
		int result = userId != null ? userId.hashCode() : 0;
		result = 31 * result + (socialLoginProvider != null ? socialLoginProvider.hashCode() : 0);
		return result;
	}
}
