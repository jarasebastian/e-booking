/**
 * 
 */
package com.ebooking.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebooking.model.Customer;
import com.ebooking.bussiness.service.CustomerService;
import com.ebooking.view.resources.vo.CustomerVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class which represents the webservice of Customer
 * 
 * @author sebastianjara
 *
 */
@RestController
@RequestMapping("/api/customer")
@Api(tags = "customer")
public class CustomerResource {

	private final CustomerService customerService;

	public CustomerResource(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	@ApiOperation(value = "Create Customer", notes = "Service for creating a new customer")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Customer was created successfully"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerVO customerVo) {
		Customer customer = new Customer();
		customer.setName(customerVo.getName());
		customer.setLastname(customerVo.getLastname());
		customer.setAddress(customerVo.getAddress());
		customer.setPhone(customerVo.getPhone());
		customer.setEmail(customerVo.getEmail());
		return new ResponseEntity<>(this.customerService.create(customer), HttpStatus.CREATED);
	}

	@PutMapping("/{identification}")
	@ApiOperation(value = "Update Customer", notes = "Service for updating an existing customer")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Customer was updated successfully"),
			@ApiResponse(code = 404, message = "Customer not found") })
	public ResponseEntity<Customer> updateCustomer(@PathVariable("identification") String identification, CustomerVO customerVo) {
		Customer customer = this.customerService.findByIdentification(identification);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}else {
			customer.setName(customerVo.getName());
			customer.setLastname(customerVo.getLastname());
			customer.setAddress(customerVo.getAddress());
			customer.setPhone(customerVo.getPhone());
			customer.setEmail(customerVo.getEmail());
		}
		return new ResponseEntity<>(this.customerService.update(customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{identification}")
	@ApiOperation(value = "Delete Customer", notes = "Service for deleting a customer")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Customer was deleted successfully"),
			@ApiResponse(code = 404, message = "Customer not found") })
	public void removeCustomer(@PathVariable("identification") String identification) {
		Customer customer = this.customerService.findByIdentification(identification);
		if (customer != null) {
			this.customerService.delete(customer);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "List Customers", notes = "Service for listing all the customers")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Customers found"),
			@ApiResponse(code = 404, message = "Customers not found") })
	public ResponseEntity<List<Customer>> findAll(){
		return ResponseEntity.ok(this.customerService.findAll());
	}

}
