/**
 * 
 */
package com.ebooking.view.resources.vo;

import lombok.Data;

/**
 * Class which represents the Customer table
 * @author sebastianjara
 *
 */
@Data
public class CustomerVO {

	private String customerId;
	private String name;
	private String lastname;
	private String identification;
	private String address;
	private String phone;
	private String email;
	
}