package com.vitasoft.controllers.user;

import static com.vitasoft.constants.Constants.Views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPageController {
	
	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		return new ModelAndView(Views.LOGIN_PAGE);
	}
	
}
