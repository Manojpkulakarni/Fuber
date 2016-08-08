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
import com.egov.fuber.entity.Rides;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CarService;
import com.egov.fuber.service.RidesService;
import com.egov.fuber.utils.FuberConstants;

/**
 * @author Manoj Kulkarni
 * 
 */
@Controller
public class ConfirmCarController {

	@Autowired
	private CarService carService;

	@Autowired
	private RidesService ridesService;

	/**
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "confirmCarForm.view", method = RequestMethod.GET)
	public String getConfirmCarFormPage(Model model) throws ServiceException {
		List<Car> cars = carService.getBookedCars();
		model.addAttribute("cars", cars);
		return "confirmCarForm";
	}

	@RequestMapping(value = "confirmCar.view", method = RequestMethod.GET)
	public @ResponseBody String confirmCar(@RequestParam("carId") Integer carId) throws ServiceException {

		List<Rides> rides = ridesService.getRideByCarIdForConfirm(carId);
		Rides ride = new Rides();
		if (rides != null && !rides.isEmpty()) {
			ride = rides.get(0);
			ride.setStatus(FuberConstants.CAR_STATUS_CONFIRMED);
			ridesService.addRide(ride);
		}
		return "Car: " + ride.getCar().getName() + " has been confirmed for the Customer: "
				+ ride.getCustomer().getName();
	}
}
