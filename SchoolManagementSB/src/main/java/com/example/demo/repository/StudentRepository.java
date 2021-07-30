package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Student;

@Repository
public class StudentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int registerStudent(Student student) {
		
		String query = "insert into student(rollno,name,age,address,gender,grade)values(?,?,?,?,?,?);";
		int insert = jdbcTemplate.update(query,student.getRollno(),student.getName(),student.getAge(),student.getAddress(),student.getGender(),student.getGrade());
		return insert;
		}
	}


