package com.capgemini.bookmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusid_seq")
	@SequenceGenerator(sequenceName = "cusid_seq", allocationSize = 1, name = "cusid_seq")
	@Column(name = "Customer_Id")
	private int customerId;

	@NotBlank(message = "please enter your name")
	@Column(name = "Custmer_Name")
	String customerName;

	@NotBlank(message = "please enter yout email")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "please enter valid email")
	@Column(name = "Email_Address")
	String emailAddress;

	@NotNull(message = "please enter the password")
	@Column(name = "Password")
	String password;

	@NotNull(message = "enter the address")
	@Column(name = "Address")
	String address;

	@NotNull(message = "enter the phone number")
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "please enter valid phone number")
	@Column(name = "Phone_Number")
	String phoneNumber;

	@NotBlank(message = "please enter the city")
	@Column(name = "City")
	String city;

	@NotNull(message = "please enter zip code")
	@Column(name = "Zipcode")
	long zipCode;

	@NotNull(message = "please enter the country")
	@Column(name = "Country")
	String country;

	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDetails(@NotBlank(message = "please enter your name") String customerName,
			@NotBlank(message = "please enter yout email") @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "please enter valid email") String emailAddress,
			@NotNull(message = "please enter the password") String password,
			@NotNull(message = "enter the address") String address,
			@NotNull(message = "enter the phone number") @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "please enter valid phone number") String phoneNumber,
			@NotBlank(message = "please enter the city") String city,
			@NotNull(message = "please enter zip code") long zipCode,
			@NotNull(message = "please enter the country") String country) {
		super();

		this.customerName = customerName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomer_Name(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
