/**
 * 
 */
package com.egov.fuber.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.egov.fuber.dao.CarDao;
import com.egov.fuber.entity.Car;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;

/**
 * @author Manoj Kulkarni
 *
 */
public class CarDaoImpl implements CarDao {
	
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
	public CarDaoImpl() {
	}

	@Override
	public void addCar(Car car) throws PersistException {
		hibernateTemplate.saveOrUpdate(car);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getAllCars() throws FetchException {
		return hibernateTemplate.find("from Car");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getAvailableCars() throws FetchException {
		return hibernateTemplate.find("from Car where isAssigned = false or isAssigned = null");
	}

	@Override
	public Car getCarById(Integer id) throws FetchException {
		return hibernateTemplate.get(Car.class, id);
	}

	@Override
	public List<Car> getBookedCars() throws FetchException {
		return hibernateTemplate.find("from Car where isAssigned = true");
	}
}
