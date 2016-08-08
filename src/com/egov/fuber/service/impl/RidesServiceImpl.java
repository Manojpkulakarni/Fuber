/**
 * 
 */
package com.egov.fuber.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.egov.fuber.dao.RidesDao;
import com.egov.fuber.entity.Rides;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CustomerService;
import com.egov.fuber.service.RidesService;

/**
 * @author Venki
 *
 */
public class RidesServiceImpl implements RidesService {

	@Autowired
	private RidesDao ridesDao;

	@Autowired
	private CustomerService customerService;

	private Logger logger = Logger.getLogger(getClass());

	/**
	 * @param carDao
	 *            the carDao to set
	 */
	public void setRidesDao(RidesDao ridesDao) {
		this.ridesDao = ridesDao;
	}

	/**
	 * 
	 */
	public RidesServiceImpl() {
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
	public void addRide(Rides rides) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			ridesDao.addRide(rides);
		} catch (PersistException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public List<Rides> getRidesByCustomerId(Integer customerId) {
		try {
			return ridesDao.getRidesByCustomerId(customerId);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Rides> getRidesByCarId(Integer carId) {
		try {
			return ridesDao.getRidesByCarId(carId);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Rides> getRideByCarIdForConfirm(Integer carId) {
		try {
			return ridesDao.getRideByCarIdForConfirm(carId);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Rides> getRideByCarIdForRelease(Integer carId) {
		try {
			return ridesDao.getRideByCarIdForRelease(carId);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Rides> getConfirmedRideByCustomerId(Integer customerId) {
		try {
			return ridesDao.getConfirmedRideByCustomerId(customerId);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Rides> getBookedRideByCustomerId(Integer customerId, Integer carId) {
		try {
			return ridesDao.getBookedRideByCustomerIdAndCarId(customerId, carId);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return null;
	}

}
