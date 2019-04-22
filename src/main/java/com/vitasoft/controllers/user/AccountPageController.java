package com.vitasoft.controllers.user;

import com.vitasoft.constants.Constants.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountPageController {
	
	@GetMapping("/account")
	public ModelAndView getAccountPage() {
		return new ModelAndView(Views.MY_ACCOUNT_PAGE);
	}
	
}
