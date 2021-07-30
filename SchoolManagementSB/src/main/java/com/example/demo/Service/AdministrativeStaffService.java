package com.example.demo.Service;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AdministrativeStaff;
import com.example.demo.Model.PaymentDetails;
import com.example.demo.repository.AdministrativeStaffRepository;
import com.example.demo.repository.PaymentDetailsRepository;

@Service
public class AdministrativeStaffService {
	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;
	@Autowired
	private AdministrativeStaffRepository administrativeStaffRepository;
	
	public int register(AdministrativeStaff administrativeStaff) {
		return administrativeStaffRepository.registerAdministrativeStaff(administrativeStaff);
        
    }
	public void login(long empID, Time loginTime)throws RuntimeException {
        System.out.println("EmployeeID: " + empID + "\nLogin Time: " + loginTime);
    }

    public void logout(long empID, Time logoutTime)throws RuntimeException {
        System.out.println("EmployeeID: " + empID + "\nLogout Time: " + logoutTime);
    }
    
    public void feeCollection(long empID,int feeCollected)throws RuntimeException {
		 System.out.println("Student rollno: " + empID+ "Fee collected: " + feeCollected);
	}
    public void payment(PaymentDetails paymentDetails)throws RuntimeException {
    	paymentDetailsRepository.save(paymentDetails);
    }
}
