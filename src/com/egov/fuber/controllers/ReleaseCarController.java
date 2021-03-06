/**
 * 
 */
package com.egov.fuber.controllers;

import java.util.List;

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
public class ReleaseCarController {

	@Autowired
	private CarService carService;

	@Autowired
	private RidesService ridesService;

	/**
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "releaseCarForm.view", method = RequestMethod.GET)
	public String getReleaseCarFormPage(Model model) throws ServiceException {
		List<Car> cars = carService.getConfirmedCars();
		model.addAttribute("cars", cars);
		return "releaseCarForm";
	}

	@RequestMapping(value = "releaseCar.view", method = RequestMethod.GET)
	public @ResponseBody String releaseCar(@RequestParam("carId") Integer carId) throws ServiceException {
		List<Rides> rides = ridesService.getRideByCarIdForRelease(carId);
		Rides ride = new Rides();
		if (rides != null && !rides.isEmpty()) {
			ride = rides.get(0);
			ride.setStatus(FuberConstants.CAR_STATUS_RELEASED);
			ridesService.addRide(ride);
		}
		return "Car: " + ride.getCar().getName() + " has been released from the Customer: "
				+ ride.getCustomer().getName();
	}
}
