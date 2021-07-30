package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentRegisterService;
import com.example.demo.repository.StudentLoginRepository;

@RestController
@RequestMapping("school/student")
public class StudentController {
	
    private final StudentRegisterService studentRegisterService;
    public  StudentController(StudentRegisterService studentRegisterService) {
    	this.studentRegisterService = studentRegisterService;
    }
    
    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody Map<String, String> map ) {
        Student student = new Student();
        student.setRollno(map.get("rollno"));
        student.setName(map.get("name"));
        student.setAge(Integer.parseInt(map.get("age")));
        student.setAddress(map.get("address"));
        student.setGender(map.get("gender"));
        student.setGrade(Integer.parseInt(map.get("grade")));
        if(studentRegisterService.registerStudent(student)==1)
			return "Successful";
		else
			return "error";
        	
     
    }


}
