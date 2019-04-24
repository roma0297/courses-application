package com.vitasoft.model;

import java.util.Collection;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class UserModel implements UserDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private Integer age;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<AuthorityModel> authorities;
	@Column(name = "account_non_expired")
	private boolean accountNonExpired;
	@Column(name = "account_non_locked")
	private boolean accountNonLocked;
	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;
	@Column(name = "enabled")
	private boolean enabled;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_profile")
	private Set<SocialProfileModel> socialProfiles;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setAuthorities(Set<AuthorityModel> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public Set<SocialProfileModel> getSocialProfiles() {
		return socialProfiles;
	}
	
	public void setSocialProfiles(Set<SocialProfileModel> socialProfiles) {
		this.socialProfiles = socialProfiles;
	}
}
