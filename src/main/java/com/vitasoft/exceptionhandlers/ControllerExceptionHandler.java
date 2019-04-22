package com.vitasoft.exceptionhandlers;

import javax.jws.WebParam.Mode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView getUnsupportedOperationExceptionView() {
		return new ModelAndView("dsfsdf");
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView returnErrorView(Exception e) {
		return new ModelAndView("errorPage")
			.addObject("exception", e);
	}
}
