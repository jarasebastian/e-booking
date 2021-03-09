/**
 * 
 */
package com.ebooking.bussiness.service;

import java.util.List;

import com.ebooking.bussiness.repository.CustomerRepository;
import com.ebooking.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class which defines the customer service layer
 * 
 * @author sebastianjara
 *
 */
@Service
@Transactional(readOnly = true)
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/**
	 * Create a customer
	 * 
	 * @param customer is an object which contains the customer info to be created
	 * 	 * @return
	 */
	@Transactional
	public Customer create(Customer customer) {
		return this.customerRepository.save(customer);
	}

	/**
	 * Update a customer
	 * 
	 * @param customer is an object which contains the customer info to be updated
	 * @return
	 */
	@Transactional
	public Customer update(Customer customer) {
		return this.customerRepository.save(customer);
	}

	/**
	 * Delete a customer
	 * 
	 * @param customer is an object which contains the customer info to be deleted
	 */
	@Transactional
	public void delete(Customer customer) {
		this.customerRepository.delete(customer);
	}

	/**
	 * Find a customer by identification
	 * 
	 * @param identification
	 * @return
	 */
	public Customer findByIdentification(String identification) {
		return this.customerRepository.findByIdentification(identification);
	}

	/**
	 * Find and return a list with all the customers
	 *
	 * @return
	 */
	public List<Customer> findAll(){
		return this.customerRepository.findAll();
	}

}
