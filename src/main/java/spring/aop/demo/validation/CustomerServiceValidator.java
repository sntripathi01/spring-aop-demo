package spring.aop.demo.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import spring.aop.demo.model.AddCustomerRequest;
import spring.aop.demo.model.DeleteCustomerRequest;
import spring.aop.demo.model.UpdateCustomerRequest;

@Component
public class CustomerServiceValidator {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomerServiceValidator.class);

	@ValidatesMethod("addCustomer")
	public void validateAddCustomer(AddCustomerRequest request) {
		if (null == request || StringUtils.isEmpty(request.getName())) {
			LOGGER.info("validateAddCustomer  validation error " + request);
		}else{
			LOGGER.info("validateAddCustomer   validation pass" + request);
		}
		
	}

	@ValidatesMethod("updateCustomer")
	public void validateUpdateCustomer(UpdateCustomerRequest request) {
		LOGGER.info("validateUpdateCustomer  " + request);
	}

	@ValidatesMethod("deleteCustomer")
	public void validateDeleteCustomer(DeleteCustomerRequest request) {
		LOGGER.info("validateDeleteCustomer  " + request);
	}

}
