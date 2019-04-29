package com.vitasoft.social;

import com.vitasoft.dao.SocialProfileRepository;
import com.vitasoft.enums.SocialLoginProvider;
import com.vitasoft.model.keys.SocialProfileKey;
import javax.annotation.Resource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class FacebookSignInAdapter implements SignInAdapter {
	
	@Resource
	private SocialProfileRepository socialProfileRepository;
	
	@Override
	public String signIn(String userId, Connection<?> connection, NativeWebRequest nativeWebRequest) {
		socialProfileRepository.findById(new SocialProfileKey(connection.getKey().getProviderUserId(), SocialLoginProvider.FACEBOOK))
			.ifPresent(socialProfile -> SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(socialProfile.getUser(), null, socialProfile.getUser().getAuthorities())));
		
		return null;
	}
}
