/**
 * 
 */
package com.egov.fuber.service;

import java.util.List;

import com.egov.fuber.entity.Rides;
import com.egov.fuber.exceptions.ServiceException;

/**
 * @author Venki
 *
 */
public interface RidesService {

	void addRide(Rides rides) throws ServiceException;

	List<Rides> getRidesByCustomerId(Integer customerId) throws ServiceException;
	
	List<Rides> getRidesByCarId(Integer carId) throws ServiceException;
	
	List<Rides> getRideByCarIdForConfirm(Integer carId) throws ServiceException;
	
	List<Rides> getRideByCarIdForRelease(Integer carId) throws ServiceException;
	
	List<Rides> getConfirmedRideByCustomerId(Integer customerId) throws ServiceException;
	
	List<Rides> getBookedRideByCustomerId(Integer customerId,Integer carId) throws ServiceException;

}
