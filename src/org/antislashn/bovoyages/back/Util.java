package org.antislashn.bovoyages.back;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class Util {
	public static boolean isLong(String i) {
		try {
			Long.parseLong(i);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static List<String> validate(Object object){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Object>> violations = validator.validate(object);
		return violations.stream()
						.map(c->c.getPropertyPath()+" "+c.getMessage())
						.collect(Collectors.toList());
		
	}
}
