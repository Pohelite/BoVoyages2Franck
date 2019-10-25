package org.antislashn.bovoyages.web.controllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.bovoyages.back.Constantes;
import org.antislashn.bovoyages.back.Util;
import org.antislashn.bovoyages.back.services.DestinationsService;
import org.antislashn.web.front.controller.Controller;

public class DeleteDestinationController implements Controller {
	private static final Logger LOG = Logger.getLogger(Constantes.TAG_LOG);

	@Override
	public String compute(HttpServletRequest request, HttpServletResponse response) {
		DestinationsService service = (DestinationsService) request.getServletContext().getAttribute(Constantes.DESTINATIONS_SERVICE);
		String id = request.getParameter("id");
		if(Util.isLong(id)) {
			service.deleteDestination(id);
			LOG.info(">>> supression destination id : "+id);
		}
		request.setAttribute("destinations", service.getAllDestinations());
		request.setAttribute("fragment", "destinationsView");
		return "home";
	}

}
