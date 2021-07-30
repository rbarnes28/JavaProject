package com.example.demo.Controller;

import java.sql.Time;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.StudentLogin;
import com.example.demo.Model.Teacher;
import com.example.demo.Model.TeacherLogin;
import com.example.demo.Service.TeacherService;

@RestController
@RequestMapping("school/teacher")
public class TeacherController {

    
    private final TeacherService teacherService;
    
    public TeacherController(TeacherService teacherService) {
    	this.teacherService = teacherService;
    }
    
    
    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody Map<String, String> map ) {
        Teacher teacher = new Teacher();
        teacher.setEmpID(Long.parseLong(map.get("empID")));
        teacher.setName(map.get("name"));
        teacher.setAge(Integer.parseInt(map.get("age")));
        teacher.setContact(map.get("contact"));
        teacher.setSalary(Long.parseLong(map.get("salary")));
        teacher.setDepartment(map.get("department"));
        teacher.setDesignation(map.get("designation"));
        teacher.setSubject(map.get("subject"));
        if(teacherService.register(teacher)==1)
			return "Successful";
		else
			return "error";
        	
     
    }
    @PostMapping(path = "attendence", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody TeacherLogin teacherLogin ) {
        Time time = new Time(System.currentTimeMillis());
        teacherLogin.setLogintime(String.valueOf(time));
        try
        {
        teacherService.login(teacherLogin);
        return ResponseEntity.ok( "Successful");
        }
        catch(RuntimeException rex) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
        }
    }
    
    @PostMapping(path = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody Map<String,Long> map ) {
        Time time = new Time(System.currentTimeMillis());
        try {
        teacherService.update(map.get("empID"));
        return  ResponseEntity.ok( "Successful");
        }
        catch(RuntimeException rex) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
        }
    }

    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody Map<String, Long> map ) {
        Time time = new Time(System.currentTimeMillis());
        try {
        teacherService.login(map.get("empID"), time);
        return ResponseEntity.ok( "Successful");
        }
        catch(RuntimeException rex) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
        }
    }

    @PostMapping(path = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> logout(@RequestBody Map<String, Long> map) {
        Time time = new Time(System.currentTimeMillis());
        try {
        teacherService.logout(map.get("empID"), time);
        return ResponseEntity.ok( "Logout Successful");
        }
        catch(RuntimeException rex) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
        }
        
    }
    @PostMapping(path = "delete", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String deleteTeacher(@RequestBody Map<String, String> map)
	{
		Teacher teacher= new Teacher();
		teacher.setEmpID(Long.parseLong(map.get("empID")));
		if(teacherService.deleteTeacher(teacher)==1)
			return "Deleted successfully"; 
		else
			return "error";
	}
    @GetMapping(path = "logindetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TeacherLogin> getAttendanceByDate(@RequestParam String entryDate) {
        return teacherService.getAttendanceByDate(entryDate);
    }
    
    
}