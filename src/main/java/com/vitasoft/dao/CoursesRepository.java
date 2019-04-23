package com.vitasoft.dao;

import com.vitasoft.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<CourseModel, String> {
	
}
