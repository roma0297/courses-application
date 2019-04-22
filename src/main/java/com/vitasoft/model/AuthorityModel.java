package com.vitasoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class AuthorityModel implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String role;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String getAuthority() {
		return role;
	}
}
