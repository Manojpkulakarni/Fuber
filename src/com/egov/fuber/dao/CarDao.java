/**
 * 
 */
package com.egov.fuber.dao;

import java.util.List;

import com.egov.fuber.entity.Car;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;

/**
 * @author Manoj Kulkarni
 *
 */
public interface CarDao {

	/**
	 * @param phone
	 * @throws PersistException
	 */
	void addCar(Car car) throws PersistException;

	List<Car> getAllCars() throws FetchException;

	List<Car> getAvailableCars() throws FetchException;
	
	Car getCarById(Integer id) throws FetchException;

	List<Car> getBookedCars()  throws FetchException;
}
