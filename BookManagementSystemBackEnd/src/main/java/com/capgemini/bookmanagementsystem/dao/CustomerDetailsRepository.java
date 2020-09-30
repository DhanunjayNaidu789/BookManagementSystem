package com.capgemini.bookmanagementsystem.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bookmanagementsystem.entity.CustomerDetails;
@Repository
@Transactional
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer>{
	
	
	
	

}
