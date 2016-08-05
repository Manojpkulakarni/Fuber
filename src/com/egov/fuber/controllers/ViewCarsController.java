/**
 * 
 */
package com.egov.fuber.controllers;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egov.fuber.entity.Car;
import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CarService;
import com.egov.fuber.service.CustomerService;
import com.egov.fuber.validators.CarValidator;

/**
 * @author Manoj Kulkarni
 * 
 */
@Controller
public class ViewCarsController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private MessageSource messageSource;

	private static final Logger LOGGER = Logger
			.getLogger(ViewCarsController.class);
	
	/**
	 * @param model
	 * @return
	 * @throws ServiceException 
	 */
	@RequestMapping(value="viewCars.view", method=RequestMethod.GET)
	public String getBookCarFormPage(Model model) throws ServiceException {
		List<Car> cars = carService.getAllCars();
		model.addAttribute("cars", cars);
		return "viewCarsForm";
	}
}
