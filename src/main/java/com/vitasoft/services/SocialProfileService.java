package com.vitasoft.services;

import com.vitasoft.dao.SocialProfileRepository;
import com.vitasoft.enums.SocialLoginProvider;
import com.vitasoft.model.SocialProfileModel;
import com.vitasoft.model.UserModel;
import javax.annotation.Resource;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Service;

@Service
public class SocialProfileService {
	
	@Resource
	private SocialProfileRepository socialProfileRepository;
	@Resource
	private UserService userService;
	
	public void createSocialProfileFromConnectionForUser(Connection connection, UserModel user) {
		SocialProfileModel socialProfile = new SocialProfileModel();
		socialProfile.setUserId(connection.getKey().getProviderUserId());
		socialProfile.setSocialLoginProvider(SocialLoginProvider.FACEBOOK);
		socialProfile.setUser(user);
		socialProfileRepository.save(socialProfile);
	}
	
}
