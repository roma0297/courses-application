package com.vitasoft.services;

import com.vitasoft.dao.AuthorityRepository;
import com.vitasoft.dao.UserRepository;
import com.vitasoft.model.UserModel;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Resource
	private UserRepository userRepository;
	@Resource
	private AuthorityRepository authorityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserModel> foundUsers = userRepository.findAllByUsername(username);
		
		if (CollectionUtils.isEmpty(foundUsers)) {
			throw new UnsupportedOperationException("No users found for username " + username);
		}
		
		if (foundUsers.size() > 1) {
			throw new UnsupportedOperationException("Multiple users found for username " + username);
		}
		
		return foundUsers.get(0);
	}
}
