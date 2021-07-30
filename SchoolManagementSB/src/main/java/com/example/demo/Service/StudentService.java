package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Model.StudentLogin;
import com.example.demo.repository.StudentLoginRepository;

@Service
public class StudentService {
 
	private final StudentLoginRepository studentLoginRepository;
	 public  StudentService(StudentLoginRepository studentLoginRepository) {
	    	this.studentLoginRepository = studentLoginRepository;
	    }
	
	
	public void login(StudentLogin studentLogin) {
		
        
        studentLoginRepository.save(studentLogin);
    }
	
   

}
