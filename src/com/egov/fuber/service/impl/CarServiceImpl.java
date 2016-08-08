/**
 * 
 */
package com.egov.fuber.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.egov.fuber.dao.CarDao;
import com.egov.fuber.entity.Car;
import com.egov.fuber.entity.Customer;
import com.egov.fuber.entity.Rides;
import com.egov.fuber.exceptions.FetchException;
import com.egov.fuber.exceptions.PersistException;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CarService;
import com.egov.fuber.service.CustomerService;
import com.egov.fuber.service.RidesService;
import com.egov.fuber.utils.FuberConstants;

/**
 * @author Manoj Kulkarni
 *
 */
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RidesService ridesService;

	private Logger logger = Logger.getLogger(getClass());

	/**
	 * @param carDao
	 *            the carDao to set
	 */
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	/**
	 * 
	 */
	public CarServiceImpl() {
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
	public void addCar(Car car) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			carDao.addCar(car);
		} catch (PersistException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Car> getAllCars() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return carDao.getAllCars();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Car> getNearestAvailableCars(Customer customer) {
		Map<Integer, Double> distanceMap = new HashMap<Integer, Double>();
		List<Car> results = new ArrayList<Car>();
		try {
			List<Car> cars = carDao.getAvailableCars();
			for (Car car : cars) {
				Double distance = Math.sqrt(Math.pow((customer.getLongitude() - car.getLongitude()), 2)
						+ Math.pow((customer.getLatitude() - car.getLatitude()), 2));
				distanceMap.put(car.getId(), distance);
			}
			distanceMap = sortByValue(distanceMap);
			for (Integer key : distanceMap.keySet()) {
				results.add(carDao.getCarById(key));
			}
			return results;
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Car>();
	}

	public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	@Override
	public Car BookNearestCar(Customer customer) throws ServiceException {
		Map<Integer, Double> distanceMap = new HashMap<Integer, Double>();
		List<Car> results = new ArrayList<Car>();
		Car nearestCar = null;
		Rides ride = new Rides();
		try {
			List<Car> cars = carDao.getAvailableCars();
			for (Car car : cars) {
				Double distance = Math.sqrt(customer.getLongitude() - car.getLongitude())
						+ Math.sqrt(customer.getLatitude() - car.getLatitude());
				distanceMap.put(customer.getId(), distance);
			}
			distanceMap = sortByValue(distanceMap);
			for (Integer key : distanceMap.keySet()) {
				results.add(carDao.getCarById(key));
			}
			if (!results.isEmpty()) {
				nearestCar = results.get(0);
				ride.setCar(nearestCar);
				ride.setCustomer(customer);
				ride.setStatus(FuberConstants.CAR_STATUS_BOOKED);
				ridesService.addRide(ride);
				nearestCar.getRides().add(ride);
				carDao.addCar(nearestCar);
			}
			return nearestCar;
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> getBookedCars() throws ServiceException {
		return carDao.getBookedCars();
	}

	@Override
	public List<Car> getConfirmedCars() throws ServiceException {
		return carDao.getConfirmedCars();
	}

	@Override
	public Car getCarById(Integer id) throws ServiceException {
		return carDao.getCarById(id);
	}

}
