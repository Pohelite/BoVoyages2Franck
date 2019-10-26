package org.antislashn.bovoyages.back.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.antislashn.bovoyages.back.dao.DatesVoyageDAO;
import org.antislashn.bovoyages.back.dao.DestinationDAO;
import org.antislashn.bovoyages.back.entities.DatesVoyage;
import org.antislashn.bovoyages.back.entities.Destination;

public class DestinationsService {
	private DestinationDAO destinationDAO;
	private DatesVoyageDAO datesVoyageDAO;
	

	public DestinationsService(EntityManagerFactory emf) {
		destinationDAO = new DestinationDAO(emf);
		datesVoyageDAO = new DatesVoyageDAO(emf);
	}
	
	public List<Destination> getAllDestinations(){
		return destinationDAO.getAllDestinations();
	}
	
	public List<String> getAllRegions(){
		return destinationDAO.getAllRegions();
	}

	public void deleteDestination(String id) {
		deleteDestination(Long.parseLong(id));
		
	}

	public void deleteDestination(long id) {
		List<DatesVoyage> datesVoyages = destinationDAO.getDatesVoyagesByIdDestination(id);
		datesVoyageDAO.delete(datesVoyages);
		destinationDAO.delete(id);
	}
	
	public void updateDestination(Destination destination) {
		destinationDAO.update(destination);
	}

	public Destination getDestinationById(long id) {
		return destinationDAO.findById(id);
	}
	
	public List<DatesVoyage> getDatesVoyagesByIdDestination(long id){
		return destinationDAO.getDatesVoyagesByIdDestination(id);
	}

	public Destination getDestinationById(String id) {
		return getDestinationById(Long.parseLong(id));
	}

	public List<DatesVoyage> getDatesVoyagesByIdDestination(String id) {
		return getDatesVoyagesByIdDestination(Long.parseLong(id));
	}

	public void save(Destination destination) {
		if(destination.getId()==0) {
			destinationDAO.create(destination);
		}else {
			destinationDAO.update(destination);
		}
		
	}
}
