package com.example.demo.Controller;

import java.sql.Time;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.AdministrativeStaff;
import com.example.demo.Model.PaymentDetails;
import com.example.demo.Service.AdministrativeStaffService;
import com.example.demo.Service.StudentService;


@RestController
@RequestMapping("school/administrative")

public class AdministrativeStaffController {
	
    private final AdministrativeStaffService administrativeStaffService;
    public  AdministrativeStaffController(AdministrativeStaffService administrativeStaffService) {
    	this.administrativeStaffService = administrativeStaffService;
    }

    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody Map<String, Long> map ) {
        Time time = new Time(System.currentTimeMillis());
        try {
        administrativeStaffService.login(map.get("empID"), time);
        return  ResponseEntity.ok( "Login Successful");
        }
       
        	catch(RuntimeException rex) {
            	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
        }
    }

    @PostMapping(path = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> logout(@RequestBody Map<String, Long> map) {
        Time time = new Time(System.currentTimeMillis());
        try {
        administrativeStaffService.logout(map.get("empID"), time);
        return  ResponseEntity.ok( "Logout Successful");
        }
        catch(RuntimeException rex) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
    }
    }
    
    @PostMapping(path = "feecollection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> feeCollection(@RequestBody Map<String, Long> map ) {
    	 int feeCollected = 10000;
    	 try {
         administrativeStaffService.feeCollection(map.get("rollno"), feeCollected);
         return  ResponseEntity.ok( "Fee collected");
    	 }
    	 catch(RuntimeException rex) {
         	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
     }
       
    }
    @PostMapping(path = "payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> payment(@RequestBody PaymentDetails paymentDetails) {
    	 Time time = new Time(System.currentTimeMillis());
    	 paymentDetails.setTime(time);  
    	 try {
    	 administrativeStaffService.payment(paymentDetails);
    	 return  ResponseEntity.ok( "Fee collected");
    	 }
    	 catch(RuntimeException rex) {
          	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
      }
    }
    	 
    	 @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    	    public String register(@RequestBody Map<String, String> map ) {
    	        AdministrativeStaff administrativeStaff = new AdministrativeStaff();
    	        administrativeStaff.setEmpID(Long.parseLong(map.get("empID")));
    	        administrativeStaff.setName(map.get("name"));
    	        administrativeStaff.setAge(Integer.parseInt(map.get("age")));
    	        administrativeStaff.setContact(map.get("contact"));
    	        administrativeStaff.setSalary(Long.parseLong(map.get("salary")));
    	        administrativeStaff.setDepartment(map.get("department"));
    	        administrativeStaff.setDesignation(map.get("designation"));
    	        if(administrativeStaffService.register(administrativeStaff)==1)
    				return "Successful";
    			else
    				return "error";
    	    }
    	    
    	

    }

