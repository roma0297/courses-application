package com.vitasoft.model;

import com.vitasoft.enums.SocialLoginProvider;
import com.vitasoft.model.keys.SocialProfileKey;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "social_profile")
@IdClass(SocialProfileKey.class)
public class SocialProfileModel {
	
	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "social_login_provider")
	@Enumerated
	private SocialLoginProvider socialLoginProvider;
	@Column(name = "email")
	private String email;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_profile")
	private UserModel user;
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public UserModel getUser() {
		return user;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
}

