package org.antislashn.bovoyages.back;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.antislashn.bovoyages.back.entities.DatesVoyage;

public class DatesVoyageValidator implements ConstraintValidator<DatesVoyageValidation,DatesVoyage>{

	@Override
	public boolean isValid(DatesVoyage dv, ConstraintValidatorContext context) {
		Date aller = dv.getDateAller();
		Date retour = dv.getDateRetour();

		return retour.compareTo(aller) > 0 ;
	}



}
