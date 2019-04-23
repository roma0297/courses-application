package com.vitasoft.dao;

import com.vitasoft.model.PersistentLoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersistentLoginRepository extends JpaRepository<PersistentLoginModel, String> {
	void deleteAllByUsername(String username);
}
