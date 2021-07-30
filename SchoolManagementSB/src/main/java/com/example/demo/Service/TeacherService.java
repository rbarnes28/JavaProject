package com.example.demo.Service;

import java.sql.Time;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Teacher;
import com.example.demo.Model.TeacherLogin;
import com.example.demo.repository.TeacherLoginRepository;
import com.example.demo.repository.TeacherRepository;


@Service
public class TeacherService {

	private final TeacherRepository teacherRepository;
	 public TeacherService(TeacherRepository teacherRepository) {
	    	this.teacherRepository = teacherRepository;
	    }
	@Autowired
	private TeacherLoginRepository teacherLoginRepository;
	 
	
	public int register(Teacher teacher) {
		return teacherRepository.registerTeacher(teacher);
        
    }
	
	public void update(long empID) throws RuntimeException{
		teacherRepository.updateTeacher();
        System.out.println("EmployeeID: " + empID +"is updated");
    }
	public void login(TeacherLogin teacherLogin)throws RuntimeException {
		
        
        teacherLoginRepository.save(teacherLogin);
    }
	
	public void login(long empID, Time loginTime) throws RuntimeException {
        System.out.println("EmployeeID: " + empID + "\nLogin Time: " + loginTime);
    }

    public void logout(long empID, Time logoutTime)throws RuntimeException {
        System.out.println("EmployeeID: " + empID + "\nLogout Time: " + logoutTime);
    }
    
    public int deleteTeacher(Teacher teacher) {
		return teacherRepository.deleteTeacher(teacher);
	}
    
    public Collection<TeacherLogin> getAttendanceByDate(String entryDate) {
        return teacherLoginRepository.getAttendanceByDate(entryDate);
    }
}
