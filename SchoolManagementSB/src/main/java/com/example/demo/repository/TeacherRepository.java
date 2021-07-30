package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Teacher;

@Repository
public class TeacherRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int registerTeacher(Teacher teacher) {
	
	String query = "insert into teacher(empID,name,age,contact,salary,department,designation,subject)values(?,?,?,?,?,?,?,?);";
	int insert = jdbcTemplate.update(query,teacher.getEmpID(),teacher.getName(),teacher.getAge(),teacher.getContact(),teacher.getSalary(),teacher.getDepartment(),teacher.getDesignation(),teacher.getSubject());
	return insert;
	}
	public int deleteTeacher(Teacher teacher)
	{
		String query = "delete from teacher  where empID = ?";
		int insert = jdbcTemplate.update(query, teacher.getEmpID());
		return insert;
	}
	
	public void updateTeacher() {
		jdbcTemplate.execute("update teacher SET name='Vaishnavi',salary=35000 where empID=2");
		//List<Map<String,Object>> details = jdbcTemplate.queryForList("select * from teacher");
		//System.out.println(details);
	}
}
