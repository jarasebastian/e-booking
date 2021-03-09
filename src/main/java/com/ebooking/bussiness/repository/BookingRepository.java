/**
 * 
 */
package com.ebooking.bussiness.repository;

import java.util.Date;
import java.util.List;

import com.ebooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interface for defining operations of relational databases with the booking
 * @author sebastianjara
 *
 */
public interface BookingRepository extends JpaRepository<Booking, String> {
	
	@Query("Select b from Booking b where b.checkinDate =:checkIn and b.checkoutDate =:checkOut")
	public List<Booking> find(@Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut);
}
