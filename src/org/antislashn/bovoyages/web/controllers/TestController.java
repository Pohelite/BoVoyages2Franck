package org.antislashn.bovoyages.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.bovoyages.back.Constantes;
import org.antislashn.bovoyages.back.entities.DatesVoyage;
import org.antislashn.bovoyages.back.entities.Destination;
import org.antislashn.bovoyages.back.services.DestinationsService;
import org.antislashn.web.front.controller.Controller;

public class TestController implements Controller {

	@Override
	public String compute(HttpServletRequest request, HttpServletResponse response) {
		DestinationsService service = (DestinationsService) request.getServletContext().getAttribute(Constantes.DESTINATIONS_SERVICE);
		Destination destination = service.getDestinationById(1);
		List<DatesVoyage> datesVoyages = service.getDatesVoyagesByIdDestination(destination.getId());
		DatesVoyage dv = datesVoyages.get(0);
		dv.setPrixHT(dv.getPrixHT()*10);
		destination.setDatesVoyages(datesVoyages);
		service.updateDestination(destination);
		request.setAttribute("fragment", "destinationsView");
		return "home";
	}

}
