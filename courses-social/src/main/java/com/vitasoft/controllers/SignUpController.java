package com.vitasoft.controllers;

import com.vitasoft.constants.Constants.Views;
import com.vitasoft.forms.SignUpForm;
import com.vitasoft.model.UserModel;
import com.vitasoft.services.SocialProfileService;
import com.vitasoft.services.UserService;
import javax.annotation.Resource;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
	
	@Resource
	private ProviderSignInUtils providerSignInUtils;
	@Resource
	private UserService userService;
	@Resource
	private SocialProfileService socialProfileService;
	@Resource
	private JdbcUsersConnectionRepository usersConnectionRepository;
	
	@GetMapping("/signup")
	public ModelAndView getSignUpPage(WebRequest webRequest) { //skdjfkj
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(webRequest);
		
		SignUpForm signUpForm = new SignUpForm();
		
		if (connection != null) {
			signUpForm.setFirstName(connection.getDisplayName().split("  ")[0]);
			signUpForm.setLastName(connection.getDisplayName().split("  ")[1]);
		}
		
		return new ModelAndView(Views.SIGN_UP_PAGE)
			.addObject("signUpForm", signUpForm)
			.addObject("isSocialUser", connection != null);
	}
	
	@PostMapping("/signup")
	public ModelAndView registerNewUser(SignUpForm signUpForm, WebRequest webRequest) {
		UserModel user = userService.createUser(signUpForm);
		
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(webRequest);
		
		if (connection != null) {
			socialProfileService.createSocialProfileFromConnectionForUser(connection, user);
			usersConnectionRepository.createConnectionRepository(connection.getKey().getProviderUserId()).addConnection(connection);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	
}
