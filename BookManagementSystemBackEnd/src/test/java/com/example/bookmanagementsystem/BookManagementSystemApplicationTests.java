package com.example.bookmanagementsystem;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.bookmanagementsystem.BookManagementSystemApplication;
import com.capgemini.bookmanagementsystem.Exceptions.CustomerNotFoundException;
import com.capgemini.bookmanagementsystem.dao.CustomerDetailsRepository;
import com.capgemini.bookmanagementsystem.entity.CustomerDetails;
import com.capgemini.bookmanagementsystem.service.CustomerDetailsService;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = BookManagementSystemApplication.class)
class BookManagementSystemApplicationTests {

	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;

	@Autowired
	private CustomerDetailsService detailsService;

	@Test
	public void testCreateCustomer() {

		CustomerDetails details = new CustomerDetails("sai", "saiprasad@gmail.com", "Sai123", "paderu", "8059408585",
				"paderu", 531056, "India");

		detailsService.createCustomer(details);

		Optional<CustomerDetails> customerDb = this.customerDetailsRepository.findById(3);

		boolean check = customerDb.isPresent();

		assertEquals(true, check);

	}

	@Test
	public void testCreateCustomer1() {

		CustomerDetails details = new CustomerDetails("sai", "saiprasad@gmail.com", "Sai123", "paderu", "8059408585",
				"paderu", 531056, "India");

		detailsService.createCustomer(details);

		Optional<CustomerDetails> customerDb = this.customerDetailsRepository.findById(55);

		boolean check = customerDb.isPresent();

		assertEquals(false, check);

	}

	@Test

	public void testGetCustomerById() throws CustomerNotFoundException {

		CustomerDetails customerDb = detailsService.getCustomerById(1);

		assertEquals("Dhanunjay Naidu", customerDb.getCustomerName());

	}

	@Test

	public void testUpdateCustomer() throws CustomerNotFoundException {

		CustomerDetails details = new CustomerDetails("Sai Prasad", "saiprasad@gmail.com", "Sai123", "paderu",
				"8059408585", "paderu", 531056, "India");
		details.setCustomerId(11);
		CustomerDetails customerDb = detailsService.updateCustomer(details);

		assertEquals("Sai Prasad", customerDb.getCustomerName());

	}

}
