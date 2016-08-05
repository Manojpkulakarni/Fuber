/**
 * 
 */
package com.egov.fuber.service;

import java.util.List;

import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.ServiceException;

/**
 * @author Manoj Kulkarni
 *
 */
public interface CustomerService {
	
	/**
	 * @param customer
	 * @throws ServiceException
	 */
	void addCustomer(Customer customer) throws ServiceException;
	
	Customer getCustomer(Integer id) throws ServiceException;
	
	/**
	 * @return
	 * @throws ServiceException
	 */
	List<Customer> getAllCustomers() throws ServiceException;
	
	List<Customer> getAvailableCustomers() throws ServiceException;
}
