/**
 * 
 */
package com.egov.fuber.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.egov.fuber.dao.RidesDao;
import com.egov.fuber.entity.Rides;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;
import com.egov.fuber.utils.FuberConstants;

/**
 * @author Venki
 *
 */
public class RidesDaoImpl implements RidesDao {

	private HibernateTemplate hibernateTemplate;

	/**
	 * @param hibernateTemplate
	 *            the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 
	 */
	public RidesDaoImpl() {
	}

	@Override
	public void addRide(Rides rides) throws PersistException {
		hibernateTemplate.saveOrUpdate(rides);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rides> getRidesByCustomerId(Integer customerId) throws FetchException {
		return hibernateTemplate.find("from Rides where customer.id = ?", customerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rides> getRidesByCarId(Integer carId) throws FetchException {
		return hibernateTemplate.find("from Rides where car.id = ?", carId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rides> getRideByCarIdForConfirm(Integer carId) throws FetchException {
		return hibernateTemplate.find("from Rides where car.id = ? and status= ?", carId,
				FuberConstants.CAR_STATUS_BOOKED);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rides> getRideByCarIdForRelease(Integer carId) throws FetchException {
		return hibernateTemplate.find("from Rides where car.id = ? and status= ?", carId,
				FuberConstants.CAR_STATUS_CONFIRMED);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rides> getConfirmedRideByCustomerId(Integer customerId) throws FetchException {
		return hibernateTemplate.find("from Rides where status = ? and customer.id = ?",
				FuberConstants.CAR_STATUS_CONFIRMED, customerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rides> getBookedRideByCustomerIdAndCarId(Integer customerId, Integer carId) throws FetchException {
		return hibernateTemplate.find("from Rides where status = ? and customer.id = ? and car.id = ?",
				FuberConstants.CAR_STATUS_BOOKED, customerId, carId);
	}

}
