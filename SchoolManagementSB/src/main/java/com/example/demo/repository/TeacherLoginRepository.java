package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.TeacherLogin;

public interface TeacherLoginRepository extends CrudRepository<TeacherLogin,String>{
	@Query("SELECT t FROM teacher_login t WHERE t.date = ?1")
    Collection<TeacherLogin> getAttendanceByDate(String date);
}
