package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.AdministrativeStaff;
@Repository
public class AdministrativeStaffRepository {
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	public  int registerAdministrativeStaff(AdministrativeStaff administrativeStaff) {
		
		String query = "insert into administrative_staff(empID,name,age,contact,salary,department,designation)values(?,?,?,?,?,?,?);";
		int insert = jdbcTemplate.update(query,administrativeStaff.getEmpID(),administrativeStaff.getName(),administrativeStaff.getAge(),administrativeStaff.getContact(),administrativeStaff.getSalary(),administrativeStaff.getDepartment(),administrativeStaff.getDesignation());
		return insert;
		}

}
