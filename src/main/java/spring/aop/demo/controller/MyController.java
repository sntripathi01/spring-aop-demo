package spring.aop.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.aop.demo.model.AddCustomerRequest;
import spring.aop.demo.model.AddCustomerResponse;
import spring.aop.demo.model.DeleteCustomerRequest;
import spring.aop.demo.model.DeleteCustomerResponse;
import spring.aop.demo.model.GetCustomerResponse;
import spring.aop.demo.model.UpdateCustomerRequest;
import spring.aop.demo.model.UpdateCustomerResponse;

@RestController
public class MyController {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MyController.class);

	@RequestMapping( value= "/add" , method = { RequestMethod.POST })
	public AddCustomerResponse addCustomer(@RequestBody AddCustomerRequest request) {
		LOGGER.info("addCustomer : " + request);
		return null;
	}

	@RequestMapping("/update")
	public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request) {
		LOGGER.info("updateCustomer : " + request);
		return null;
	}

	@RequestMapping("/delete")
	public DeleteCustomerResponse deleteCustomer(@RequestBody DeleteCustomerRequest request) {
		LOGGER.info("deleteCustomer : " + request);
		return null;
	}

	@RequestMapping("/get")
	public GetCustomerResponse getCustomer() {
		LOGGER.info("getCustomer : ");
		return null;
	}

}
