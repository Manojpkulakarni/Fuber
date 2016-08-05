/**
 * 
 */
package com.egov.fuber.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egov.fuber.entity.Car;
import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CarService;

/**
 * @author Manoj Kulkarni
 * 
 */
@Controller
public class ReleaseCarController {

	@Autowired
	private CarService carService;
	
	private static final Logger LOGGER = Logger
			.getLogger(ReleaseCarController.class);
	
	/**
	 * @param model
	 * @return
	 * @throws ServiceException 
	 */
	@RequestMapping(value="releaseCarForm.view", method=RequestMethod.GET)
	public String getReleaseCarFormPage(Model model) throws ServiceException {
		List<Car> cars = carService.getBookedCars();
		model.addAttribute("cars", cars);
		return "releaseCarForm";
	}
	
	@RequestMapping(value="releaseCar.view", method=RequestMethod.GET)
	public @ResponseBody String releaseCar(@RequestParam("carId") Integer carId) throws ServiceException {
		Car car = carService.getCarById(carId);
		Customer customer = car.getCustomer();
		carService.releaseCar(car);
		return "Car: " + car.getName() + " has been released from the Customer: " + customer.getName();
	}
}
