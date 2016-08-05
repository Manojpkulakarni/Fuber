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

import com.egov.fuber.entity.Customer;
import com.egov.fuber.exceptions.ServiceException;
import com.egov.fuber.service.CustomerService;
import com.egov.fuber.validators.CustomerValidator;

/**
 * @author Manoj Kulkarni
 * 
 */
@Controller
public class CreateCustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private MessageSource messageSource;

	private static final Logger LOGGER = Logger
			.getLogger(CreateCustomerController.class);
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("customerForm.view")
	public String getCustomerFormPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerForm";
	}

	@RequestMapping("addCustomer.view")
	public String addCustomer(@ModelAttribute("customer") Customer customer,
			BindingResult results, Locale locale, Model model) {
		String page = "redirect:home.view";
		CustomerValidator validator = new CustomerValidator();
		validator.validate(customer, results);
		if(results.hasErrors()){
			return "customerForm";
		}
		try {
			customerService.addCustomer(customer);
			model.addAttribute(
					"message",
					messageSource.getMessage(
							"customer.add.succes",
							new Object[] { customer.getName() },
							"Customer " + customer.getName() + " added Successfully",
							locale));
		} catch (ServiceException e) {
			LOGGER.debug(e.getMessage());
			model.addAttribute("errorMessage", messageSource.getMessage(
					"customer.add.error", new Object[] { customer.getName() },
					"Unable to add Customer", locale));
		}
		return page;
	}
	
	@RequestMapping("getCustomers.view")
	public @ResponseBody List<Customer> getCustomers(Model model){
		List<Customer> customers = null;
		try {
			customers = customerService.getAllCustomers();
		} catch (ServiceException e) {
			LOGGER.debug(e.getMessage());
		}
		return customers;
	}
}
