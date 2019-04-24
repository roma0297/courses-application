package com.vitasoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authority")
public class AuthorityModel implements GrantedAuthority {
	
	@Id
	@Column(name = "role")
	private String role;
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String getAuthority() {
		return role;
	}
}
