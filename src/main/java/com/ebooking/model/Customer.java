/**
 * 
 */
package com.ebooking.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class which represents the Customer table
 * @author sebastianjara
 *
 */
@Data
@Entity
@Table(name = "customer")
@NamedQuery(name="Customer.findByIdentification", query="Select c from Customer c where c.identification = ?1")
public class Customer {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String customerId;
	private String name;
	private String lastname;
	private String identification;
	private String address;
	private String phone;
	private String email;
	@OneToMany(mappedBy="customer")
	private Set<Booking> bookings;
	
	public Customer() {}
	
}
