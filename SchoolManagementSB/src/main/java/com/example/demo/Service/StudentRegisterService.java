package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;

import com.example.demo.repository.StudentRepository;
@Service
public class StudentRegisterService {
	@Autowired 
	
	private StudentRepository studentRepository;
	public int registerStudent(Student student) {
		return studentRepository.registerStudent(student);
        
    }
}
