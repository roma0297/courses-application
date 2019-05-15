package com.vitasoft.dao;

import com.vitasoft.model.UserModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	List<UserModel> findAllByUsername(String username);
	
}
