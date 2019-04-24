package com.vitasoft.social;

import com.vitasoft.dao.AuthorityRepository;
import com.vitasoft.dao.SocialProfileRepository;
import com.vitasoft.dao.UserRepository;
import com.vitasoft.enums.SocialLoginProvider;
import com.vitasoft.model.AuthorityModel;
import com.vitasoft.model.SocialProfileModel;
import com.vitasoft.model.UserModel;
import java.util.Collections;
import javax.annotation.Resource;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

@Component
public class FacebookConnectionSignUp implements ConnectionSignUp {
	
	@Resource
	private UserRepository userRepository;
	@Resource
	private SocialProfileRepository socialProfileRepository;
	@Resource
	private AuthorityRepository authorityRepository;
	
	@Override
	public String execute(Connection<?> connection) {
		UserModel user = new UserModel();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setUsername(connection.getDisplayName().split("  ")[0]);
		AuthorityModel authority = new AuthorityModel();
		authority.setRole("ROLE_USER");
		authorityRepository.save(authority);
		user.setAuthorities(Collections.singleton(authority));
		userRepository.save(user);
		
		SocialProfileModel socialProfile = new SocialProfileModel();
		socialProfile.setUserId(connection.getKey().getProviderUserId());
		socialProfile.setFirstName(connection.getDisplayName().split("  ")[0]);
		socialProfile.setLastName(connection.getDisplayName().split("  ")[1]);
		socialProfile.setSocialLoginProvider(SocialLoginProvider.FACEBOOK);
		socialProfile.setUser(user);
		socialProfileRepository.save(socialProfile);
		
		return user.getUsername();
	}
}
