package org.antislashn.bovoyages.web.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.bovoyages.back.Constantes;
import org.antislashn.bovoyages.back.Util;
import org.antislashn.bovoyages.back.entities.DatesVoyage;
import org.antislashn.bovoyages.back.entities.Destination;
import org.antislashn.bovoyages.back.services.DestinationsService;
import org.antislashn.web.front.controller.Controller;


/**
 * Controleur de gestion de la sauvegarde des destinations
 * 
 * @author franck
 *
 */
public class SaveDestinationController implements Controller {
		private static final Logger LOG = Logger.getLogger(Constantes.TAG_LOG);
		private DestinationsService service;
		private List<String> erreurs;

	@Override
	public String compute(HttpServletRequest request, HttpServletResponse response) {
		service = (DestinationsService) request.getServletContext().getAttribute(Constantes.DESTINATIONS_SERVICE);
		erreurs = new ArrayList<>();
		// chargement d'une destination existante ou création d'une nouvelle
		Destination destination = findOrCreateDestination(request.getParameter("id"));
		
		destination.setRegion(request.getParameter("region"));
		destination.setDescription(request.getParameter("description"));
		
		// récupération de la liste des DatesVoyage
		List<DatesVoyage> dates = getDatesVoyages(request);
		destination.setDatesVoyages(dates);
		
		erreurs.addAll(Util.validate(destination));
		
		// S'il y a des erreurs on renvoie le formulaire
		if(!erreurs.isEmpty()) {
			String title = destination.getId()==0 ? "Création d'une destination": "Modification d'une destination";
			request.setAttribute("cde", "saveDest");
			request.setAttribute("title", title);
			request.setAttribute("fragment", "destinationDetailsView");
			request.setAttribute("destination", destination);
			request.setAttribute("datesVoyages", dates);
			request.setAttribute("erreurs", erreurs);
			return "home";
		}
		
		service.save(destination);
		request.setAttribute("destinations", service.getAllDestinations());
		request.setAttribute("fragment", "destinationsView");
		return "home";
	}

	private List<DatesVoyage> getDatesVoyages(HttpServletRequest request) {
		List<DatesVoyage> dates = new ArrayList<>();
		int num = 1;
		// tant qu'il existe une paramètre numéroté valide, on crée des DatesVoyage
		while(true) {
			String jourDepartStr = request.getParameter("depart_jour_"+num);
			if(jourDepartStr == null) {
				break;
			}
			String moisDepartStr = request.getParameter("depart_mois_"+num);
			String anDepartStr = request.getParameter("depart_an_"+num);
			String jourRetourStr = request.getParameter("retour_jour_"+num);
			String moisRetourStr = request.getParameter("retour_mois_"+num);
			String anRetourStr = request.getParameter("retour_an_"+num);
			
			try {
				Date depart = new Date(Integer.parseInt(anDepartStr)-1900,Integer.parseInt(moisDepartStr)-1,Integer.parseInt(jourDepartStr));
				Date retour = new Date(Integer.parseInt(anRetourStr)-1900,Integer.parseInt(moisRetourStr)-1,Integer.parseInt(jourRetourStr));
				int nbPlaces = Integer.parseInt(request.getParameter("places_"+num));
				double prixHT = Double.parseDouble(request.getParameter("prix_"+num).replace(",", "."));
				long id = Long.parseLong(request.getParameter("iddv_"+num));
				DatesVoyage dv = new DatesVoyage();
				dv.setDateAller(depart);
				dv.setDateRetour(retour);
				dv.setId(id);
				dv.setNbPlaces(nbPlaces);
				dv.setPrixHT(prixHT);
				dates.add(dv);
			}catch(NumberFormatException e) {
				LOG.log(Level.SEVERE, "Erreur de format", e);
				erreurs.add("Erreur de format de nombre : vérifiez les dates, prix et nombre de places");
			}catch (Exception e) {
				LOG.log(Level.SEVERE, "Erreur de sur itération "+num, e);
			}
			num++;
		}
		
		return dates;
	}

	private Destination findOrCreateDestination(String id) {
		Destination destination;
		if(id == null || id.equals("0") || !Util.isLong(id)){
			destination = new Destination();
		}else {
			destination = service.getDestinationById(id);
			if(destination==null) {
				destination = new Destination();
			}
		}
		return destination;
	}

}
