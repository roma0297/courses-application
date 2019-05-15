package com.vitasoft.dao;

import com.vitasoft.model.AuthorityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {
	
}
