package com.vitasoft.services;

import com.vitasoft.exceptions.UnknownIdentifierException;
import com.vitasoft.model.CourseModel;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {
	
	private static final List<CourseModel> COURSES = Arrays.asList(
		new CourseModel("1", "Java course", "", 1000.0),
		new CourseModel("2", "Python course", "", 2000.0),
		new CourseModel("3", "Spring course", "", 3000.0));
	
	public List<CourseModel> getCourses() {
		return COURSES;
	}
	
	public CourseModel getCourse(String id) {
		return COURSES.stream()
			.filter(course -> id.equals(course.getId()))
			.findFirst()
			.orElseThrow(() -> new UnknownIdentifierException("Course with id " + id + " wasn't found"));
	}
	
	public void removeCourse(String id) {
		COURSES.removeIf(course -> id.equals(course.getId()));
	}
	
}
