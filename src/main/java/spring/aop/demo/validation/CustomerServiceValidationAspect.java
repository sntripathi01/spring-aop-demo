package spring.aop.demo.validation;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerServiceValidationAspect {

	@Autowired
	private CustomerServiceValidator customerServiceValidator;

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
			.getLogger(CustomerServiceValidationAspect.class);

	@Around("execution(* spring.aop.demo.controller.MyController.*(..))")
	public void aroundCustomerServiceValidation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		LOGGER.info("CustomerServiceValidationAspect : aroundCustomerServiceValidation Before");
		Method[] methods = customerServiceValidator.getClass().getMethods();
		for (Method method : methods) {
			ValidatesMethod annotation = method.getAnnotation(ValidatesMethod.class);
			if (null != annotation && annotation.value().equals(proceedingJoinPoint.getSignature().getName())) {
				method.invoke(customerServiceValidator, proceedingJoinPoint.getArgs());
				break;
			}
		}
		proceedingJoinPoint.proceed();
		LOGGER.info("CustomerServiceValidationAspect : aroundCustomerServiceValidation After");

		
	}

}
