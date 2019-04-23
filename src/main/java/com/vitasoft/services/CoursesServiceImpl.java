package com.vitasoft.services;

import com.vitasoft.dao.CoursesRepository;
import com.vitasoft.exceptions.UnknownIdentifierException;
import com.vitasoft.model.CourseModel;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class CoursesServiceImpl {
	
	@Resource
	private CoursesRepository coursesRepository;
	
	public List<CourseModel> getCourses() {
		return coursesRepository.findAll();
	}
	
	public CourseModel getCourse(String id) {
		return coursesRepository.findById(id).orElseThrow(() -> new UnknownIdentifierException("Course with id " + id + " wasn't found"));
	}
	
	@Secured(value = "ROLE_ADMIN")
	public void removeCourse(String id) {
		coursesRepository.deleteById(id);
	}
}
