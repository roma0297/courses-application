package com.vitasoft.controllers.user;

import com.vitasoft.constants.Constants.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	
	@GetMapping(value = {"/", "/home"})
	public ModelAndView getHomePage() {
		return new ModelAndView(Views.HOME_PAGE);
	}
}
