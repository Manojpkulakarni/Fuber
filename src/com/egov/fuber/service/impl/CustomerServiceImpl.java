/**
 * 
 */
package com.egov.fuber.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.egov.fuber.dao.CustomerDao;
import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CustomerService;

/**
 * @author Manoj Kulkarni
 *
 */
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	private Logger logger = Logger.getLogger(getClass());
	
	

	/**
	 * @param customerDao the customerDao to set
	 */
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * 
	 */
	public CustomerServiceImpl() {
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=ServiceException.class)
	public void addCustomer(Customer customer) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			customerDao.addCustomer(customer);
		} catch (PersistException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Customer> getAllCustomers() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return customerDao.getAllCustomers();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Customer getCustomer(Integer id) throws ServiceException {
		return customerDao.getCustomer(id);
	}

	@Override
	public List<Customer> getAvailableCustomers() throws ServiceException {
		return customerDao.getAvailableCustomers();
	}
}
