package org.antislashn.bovoyages.back;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = DatesVoyageValidator.class)
public @interface DatesVoyageValidation {
	String message() default "La date de retour ne peut pas être antérieure à la date aller";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
