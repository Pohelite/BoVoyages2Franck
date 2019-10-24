package org.antislashn.bovoyages.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.bovoyages.back.Constantes;
import org.antislashn.bovoyages.back.services.DestinationsService;
import org.antislashn.web.front.controller.Controller;

public class ViewDestinationsController implements Controller {

	@Override
	public String compute(HttpServletRequest request, HttpServletResponse response) {
		DestinationsService service = (DestinationsService) request.getServletContext().getAttribute(Constantes.DESTINATIONS_SERVICE);
		request.setAttribute("destinations", service.getAllDestinations());
		request.setAttribute("fragment", "destinationsView");
		return "home";
	}

}
