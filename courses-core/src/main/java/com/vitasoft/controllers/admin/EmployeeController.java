package com.vitasoft.controllers.admin;

import javax.xml.parsers.ParserConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("/admin/employees")
	public String javaTutorial(Model model) throws ParserConfigurationException {
		Resource resource = resourceLoader.getResource("classpath:employees.xml");
		
		model.addAttribute("employees", resource);
		return "employees";
	}
}
