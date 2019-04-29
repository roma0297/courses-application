package com.vitasoft.services;

import com.vitasoft.dao.AuthorityRepository;
import com.vitasoft.dao.UserRepository;
import com.vitasoft.forms.SignUpForm;
import com.vitasoft.model.AuthorityModel;
import com.vitasoft.model.UserModel;
import java.util.Collections;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Resource
	private UserRepository userRepository;
	@Resource
	private AuthorityRepository authorityRepository;
	
	//	TODO: It's not the best approach. The better solution would be to create a converter to convert from form to UserModel
	public UserModel createUser(SignUpForm signUpForm) {
		UserModel user = new UserModel();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setUsername(signUpForm.getFirstName());
		AuthorityModel authority = new AuthorityModel();
		authority.setRole("ROLE_USER");
		authorityRepository.save(authority);
		user.setAuthorities(Collections.singleton(authority));
		userRepository.save(user);
		
		return user;
	}
	
}
