/**
 * 
 */
package com.egov.fuber.dao;

import java.util.List;

import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;

/**
 * @author Manoj Kulkarni
 *
 */
public interface CustomerDao {

	/**
	 * @param customer
	 * @throws PersistException
	 */
	void addCustomer(Customer customer) throws PersistException;

	List<Customer> getAllCustomers() throws FetchException;

	Customer getCustomer(Integer id) throws FetchException;

	List<Customer> getAvailableCustomers() throws FetchException;
}
