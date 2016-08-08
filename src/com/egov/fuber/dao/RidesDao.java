/**
 * 
 */
package com.egov.fuber.dao;

import java.util.List;

import com.egov.fuber.entity.Rides;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;

/**
 * @author Venki
 *
 */
public interface RidesDao {

	/**
	 * @param rides
	 * @throws PersistException
	 */
	void addRide(Rides rides) throws PersistException;

	List<Rides> getRidesByCustomerId(Integer customerId) throws FetchException;
	
	List<Rides> getRidesByCarId(Integer carId) throws FetchException;
	
	List<Rides> getRideByCarIdForConfirm(Integer carId) throws FetchException;
	
	List<Rides> getRideByCarIdForRelease(Integer carId) throws FetchException;

	List<Rides> getConfirmedRideByCustomerId(Integer customerId) throws FetchException;
	
	List<Rides> getBookedRideByCustomerIdAndCarId(Integer customerId,Integer carId) throws FetchException;

}
