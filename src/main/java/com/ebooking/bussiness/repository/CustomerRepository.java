package com.ebooking.bussiness.repository;

import java.util.List;

import com.ebooking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for defining operations of relational databases with the costumer
 * @author sebastianjara
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, String>{

	public List<Customer> findByLastname(String lastname);
	
	public Customer findByIdentification(String indentification);
	
}
