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
import org.springframework.web.bind.annotation.ResponseBody;

import com.egov.fuber.entity.Car;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CarService;
import com.egov.fuber.validators.CarValidator;

/**
 * @author Manoj Kulkarni
 * 
 */
@Controller
public class CreateCarController {

	@Autowired
	private CarService carService;

	@Autowired
	private MessageSource messageSource;

	private static final Logger LOGGER = Logger
			.getLogger(CreateCarController.class);
	
	@RequestMapping("home.view")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping("cancel.view")
	public String returnHomePage() {
		return "home";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("carForm.view")
	public String getCarFormPage(Model model) {
		model.addAttribute("car", new Car());
		return "carForm";
	}

	@RequestMapping("addCar.view")
	public String addPhone(@ModelAttribute("car") Car car,
			BindingResult results, Locale locale, Model model) {
		String page = "redirect:home.view";
		CarValidator validator = new CarValidator();
		validator.validate(car, results);
		if(results.hasErrors()){
			return "carForm";
		}
		try {
			carService.addCar(car);
			model.addAttribute(
					"message",
					messageSource.getMessage(
							"car.add.succes",
							new Object[] { car.getName() },
							"Car " + car.getName() + " added Successfully",
							locale));
		} catch (ServiceException e) {
			LOGGER.debug(e.getMessage());
			model.addAttribute("errorMessage", messageSource.getMessage(
					"car.add.error", new Object[] { car.getName() },
					"Unable to add Car", locale));
		}
		return page;
	}
	
	@RequestMapping("getCars.view")
	public @ResponseBody List<Car> getModels(Model model){
		List<Car> cars = null;
		try {
			cars = carService.getAllCars();
			System.out.println("Size ------------------" +cars.size());
		} catch (ServiceException e) {
			LOGGER.debug(e.getMessage());
		}
		return cars;
	}
}
