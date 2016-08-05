/**
 * 
 */
package com.egov.fuber.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.egov.fuber.dao.CustomerDao;
import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;

/**
 * @author Manoj Kulkarni
 *
 */
public class CustomerDaoImpl implements CustomerDao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 
	 */
	public CustomerDaoImpl() {
	}

	@Override
	public void addCustomer(Customer customer) throws PersistException {
		hibernateTemplate.saveOrUpdate(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() throws FetchException {
		return hibernateTemplate.find("from Customer");
	}

	@Override
	public Customer getCustomer(Integer id) throws FetchException {
		return hibernateTemplate.get(Customer.class, id);
	}

	@Override
	public List<Customer> getAvailableCustomers() throws FetchException {
		return hibernateTemplate.find("from Customer where isBooked = false or isBooked = null");
	}
}
