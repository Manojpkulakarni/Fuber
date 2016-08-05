/**
 * 
 */
package com.egov.fuber.service;

import java.util.List;

import com.egov.fuber.entity.Car;
import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.ServiceException;

/**
 * @author Manoj Kulkarni
 *
 */
public interface CarService {
	
	/**
	 * @param car
	 * @throws ServiceException
	 */
	void addCar(Car car) throws ServiceException;
	
	/**
	 * @return
	 * @throws ServiceException
	 */
	List<Car> getAllCars() throws ServiceException;

	List<Car> getNearestAvailableCars(Customer customer) throws ServiceException;

	Car BookNearestCar(Customer customer) throws ServiceException;

	List<Car> getBookedCars() throws ServiceException;
	
	Car getCarById(Integer id) throws ServiceException;

	void releaseCar(Car car) throws ServiceException;
}
