package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.PaymentDetails;

public interface PaymentDetailsRepository extends CrudRepository<PaymentDetails,String> {
   
}
