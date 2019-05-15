package com.vitasoft.dao;

import com.vitasoft.model.PersistentLoginModel;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

@Repository("persistentTokenRepository")
public class PersistentTokenRepositoryImpl implements PersistentTokenRepository {
	
	@Resource
	private PersistentLoginRepository persistentLoginRepository;
	
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		PersistentLoginModel persistentLogin = new PersistentLoginModel();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLastUsed(token.getDate());
		persistentLoginRepository.save(persistentLogin);
	}
	
	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		return persistentLoginRepository.findById(seriesId)
			.map(persistentLogin -> new PersistentRememberMeToken(persistentLogin.getUsername(),
				persistentLogin.getSeries(), persistentLogin.getToken(), persistentLogin.getLastUsed()))
			.orElse(null);
	}
	
	@Override
	public void removeUserTokens(String username) {
		persistentLoginRepository.deleteAllByUsername(username);
	}
	
	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		persistentLoginRepository.findById(series).ifPresent(persistentLogin -> {
			persistentLogin.setToken(tokenValue);
			persistentLogin.setLastUsed(lastUsed);
		});
	}
}
