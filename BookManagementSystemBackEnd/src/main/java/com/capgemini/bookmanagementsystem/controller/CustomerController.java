package com.capgemini.bookmanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmanagementsystem.Exceptions.CustomerNotFoundException;
import com.capgemini.bookmanagementsystem.entity.CustomerDetails;
import com.capgemini.bookmanagementsystem.service.CustomerDetailsService;

@RestController
@RequestMapping("verson1.0/")
@Validated
public class CustomerController {

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@GetMapping("AllCustomers")
	public ResponseEntity<List<CustomerDetails>> getAllCustomers() {
		return ResponseEntity.ok().body(customerDetailsService.getAllCustomers());
	}

	@GetMapping("findCustomer/{id}")
	public ResponseEntity<CustomerDetails> getCustomerById(@PathVariable int id) throws CustomerNotFoundException {

		return ResponseEntity.ok().body(customerDetailsService.getCustomerById(id));
	}

	@PostMapping("createCustomer")
	public ResponseEntity<CustomerDetails> createCustomer(@RequestBody @Valid CustomerDetails details) {
		return ResponseEntity.ok().body(this.customerDetailsService.createCustomer(details));
	}

	@PutMapping("updateCustomer/{id}")
	public ResponseEntity<CustomerDetails> updateCustomer(@PathVariable int id,
			@RequestBody @Valid CustomerDetails details) throws CustomerNotFoundException {
		details.setCustomerId(id);
		return ResponseEntity.ok().body(this.customerDetailsService.updateCustomer(details));
	}

	@DeleteMapping("deleteCustomer/{id}")
	public HttpStatus deleteProduct(@PathVariable int id) throws CustomerNotFoundException {
		this.customerDetailsService.deleteCustomer(id);
		;
		return HttpStatus.OK;
	}

}