package com.example.demo.Controller;

import java.sql.Time;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.StudentLogin;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("school/student")
public class StudentLoginController {

    
    private final StudentService studentService;
    public  StudentLoginController(StudentService studentService) {
    	this.studentService = studentService;
    }
    
    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody StudentLogin studentLogin ) {
        Time time = new Time(System.currentTimeMillis());
        studentLogin.setLogintime(String.valueOf(time));
        studentService.login(studentLogin);
        return "Successful";
    }
   
    }

    


