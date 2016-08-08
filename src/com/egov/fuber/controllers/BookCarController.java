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
import com.egov.fuber.service.CustomerService;
import com.egov.fuber.service.RidesService;

/**
 * @author Manoj Kulkarni
 * 
 */
@Controller
public class BookCarController {

	@Autowired
	private CarService carService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RidesService ridesService;

	private static final Logger LOGGER = Logger.getLogger(BookCarController.class);

	/**
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "bookCarForm.view", method = RequestMethod.GET)
	public String getBookCarFormPage(Model model) throws ServiceException {
		List<Customer> customers = customerService.getAvailableCustomers();
		model.addAttribute("customers", customers);
		return "bookCarForm";
	}

	@RequestMapping(value = "searchCars.view", method = RequestMethod.GET)
	public @ResponseBody List<Car> searchCars(@RequestParam("customerId") Integer customerId, Model model)
			throws ServiceException {
		List<Car> cars = carService.getNearestAvailableCars(customerService.getCustomer(customerId));
		return cars;
	}

	@RequestMapping(value = "bookCar.view", method = RequestMethod.GET)
	public @ResponseBody String bookCar(@RequestParam("customerId") Integer customerId) throws ServiceException {
		Customer customer = customerService.getCustomer(customerId);
		Car car = carService.BookNearestCar(customer);

		if (car != null)
			return "Car: " + car.getName() + " has been booked for the customer: " + customer.getName();
		else
			return "Request has been rejected as no cabs available at this moment";
	}

}
