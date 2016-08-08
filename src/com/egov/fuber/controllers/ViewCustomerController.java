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

import com.egov.fuber.entity.Customer;
import com.egov.fuber.entity.Rides;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CustomerService;
import com.egov.fuber.service.RidesService;

/**
 * @author Venki
 * 
 */
@Controller
public class ViewCustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RidesService ridesService;

	/**
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "viewCustomers.view", method = RequestMethod.GET)
	public String getCustomersFormViewPage(Model model) throws ServiceException {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "viewCustomers";
	}

	@RequestMapping(value = "viewBookingHistory.view", method = RequestMethod.GET)
	public String viewBookingHistory(@RequestParam("customerId") Integer customerId, Model model)
			throws ServiceException {
		List<Rides> rides = ridesService.getRidesByCustomerId(customerId);
		model.addAttribute("rides", rides);
		return "viewBookingHistory";
	}

}
