package com.vitasoft.controllers.user;

import com.vitasoft.constants.Constants.Views;
import com.vitasoft.services.CoursesService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoursesPageController {
	
	@Resource
	private CoursesService coursesService;
	
	@GetMapping("/courses")
	public ModelAndView getCoursesPage() {
		return new ModelAndView(Views.COURSES_PAGE)
			.addObject("courses", coursesService.getCourses());
	}
	
	@GetMapping("/courses/{id}")
	public ModelAndView getCoursePage(@PathVariable String id) {
		return new ModelAndView(Views.COURSE_PAGE)
			.addObject("course", coursesService.getCourse(id));
	}
	
	@GetMapping("/courses-pdf")
	public ModelAndView getCoursesDetails() {
		return new ModelAndView(Views.COURSES_PDF)
			.addObject("courses", coursesService.getCourses());
	}
	
}