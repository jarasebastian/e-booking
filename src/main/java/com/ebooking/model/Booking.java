/**
 * 
 */
package com.ebooking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class which represents the booking table
 * @author sebastianjara
 *
 */
@Data
@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String bookingId;
	@Temporal(TemporalType.DATE)
	private Date checkinDate;
	@Temporal(TemporalType.DATE)
	private Date checkoutDate;
	private int phone;
	private String description;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
}
