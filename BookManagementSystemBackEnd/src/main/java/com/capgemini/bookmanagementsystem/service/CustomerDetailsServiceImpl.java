package com.capgemini.bookmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmanagementsystem.Exceptions.CustomerNotFoundException;
import com.capgemini.bookmanagementsystem.dao.CustomerDetailsRepository;
import com.capgemini.bookmanagementsystem.entity.CustomerDetails;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;

	@Override
	public CustomerDetails createCustomer(CustomerDetails details) {
		return customerDetailsRepository.save(details);
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetails details) throws CustomerNotFoundException {

		Optional<CustomerDetails> customerDb = this.customerDetailsRepository.findById(details.getCustomerId());
		if (customerDb.isPresent()) {
			CustomerDetails customerUpdate = customerDb.get();
			customerUpdate.setCustomerId(details.getCustomerId());
			customerUpdate.setCustomer_Name(details.getCustomerName());
			customerUpdate.setAddress(details.getAddress());
			customerUpdate.setCity(details.getCity());
			customerUpdate.setCountry(details.getCountry());
			customerUpdate.setEmailAddress(details.getEmailAddress());
			customerUpdate.setPassword(details.getPassword());
			customerUpdate.setPhoneNumber(details.getPhoneNumber());
			customerUpdate.setZipCode(details.getZipCode());
			customerDetailsRepository.save(customerUpdate);
			return customerUpdate;
		} else {
			throw new CustomerNotFoundException("Record not found with id : " + details.getCustomerId());
		}

	}

	@Override
	public List<CustomerDetails> getAllCustomers() {

		return this.customerDetailsRepository.findAll();
	}

	@Override
	public CustomerDetails getCustomerById(int customerId) throws CustomerNotFoundException {

		Optional<CustomerDetails> customerDb = this.customerDetailsRepository.findById(customerId);

		if (customerDb.isPresent()) {
			return customerDb.get();
		} else {
			throw new CustomerNotFoundException("Record not found with id : " + customerId);
		}
	}

	@Override
	public void deleteCustomer(int customerId) throws CustomerNotFoundException {

		Optional<CustomerDetails> customerDb = this.customerDetailsRepository.findById(customerId);

		if (customerDb.isPresent()) {
			this.customerDetailsRepository.delete(customerDb.get());
		} else {
			throw new CustomerNotFoundException("Record not found with id : " + customerId);
		}

	}

}
