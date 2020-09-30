package com.capgemini.bookmanagementsystem.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.capgemini.bookmanagementsystem.Exceptions.CustomerNotFoundException;
import com.capgemini.bookmanagementsystem.entity.CustomerDetails;
@Service
public interface CustomerDetailsService {
	
	    CustomerDetails createCustomer(CustomerDetails details);

	    CustomerDetails updateCustomer(CustomerDetails details)throws CustomerNotFoundException;

	    List < CustomerDetails> getAllCustomers();

	    CustomerDetails getCustomerById(int productId)throws CustomerNotFoundException;

	    void deleteCustomer(int id)throws CustomerNotFoundException;
	
	

}
