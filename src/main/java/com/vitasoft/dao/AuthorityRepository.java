package com.vitasoft.dao;

import com.vitasoft.model.AuthorityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {
	
}
