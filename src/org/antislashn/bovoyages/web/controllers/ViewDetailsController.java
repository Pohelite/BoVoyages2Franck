package org.antislashn.bovoyages.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.bovoyages.back.Constantes;
import org.antislashn.bovoyages.back.Util;
import org.antislashn.bovoyages.back.entities.DatesVoyage;
import org.antislashn.bovoyages.back.entities.Destination;
import org.antislashn.bovoyages.back.services.DestinationsService;
import org.antislashn.web.front.controller.Controller;
/**
 * Affichage du formaulaire de saisie ou midification d'une destination
 * @author franck
 *
 */
public class ViewDetailsController implements Controller {

	/**
	 * si le paramètre 'id' est à 0, il s'agit d'une demande de création d'une destination
	 * 
	 */
	@Override
	public String compute(HttpServletRequest request, HttpServletResponse response) {
		DestinationsService service = (DestinationsService) request.getServletContext().getAttribute(Constantes.DESTINATIONS_SERVICE);
		String id = request.getParameter("id");
		id = Util.isLong(id) == true ? id : "0";
		String title = "";
		String cde="saveDest";
		if(id.equals("0")) {
			title = "Création d'une destination";
		}else {
			title = "Modification d'une destination";
			Destination destination = service.getDestinationById(id);
			List<DatesVoyage> datesVoyages = service.getDatesVoyagesByIdDestination(id);
			request.setAttribute("destination", destination);
			request.setAttribute("datesVoyages", datesVoyages);
		}
		request.setAttribute("cde", cde);
		request.setAttribute("title", title);
		request.setAttribute("fragment", "destinationDetailsView");
		return "home";
	}

}
