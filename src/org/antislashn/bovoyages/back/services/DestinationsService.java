package org.antislashn.bovoyages.back.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.antislashn.bovoyages.back.dao.DestinationDAO;
import org.antislashn.bovoyages.back.entities.Destination;

public class DestinationsService {
	private DestinationDAO dao;

	public DestinationsService(EntityManagerFactory emf) {
		dao = new DestinationDAO(emf);
	}
	
	public List<Destination> getAllDestinations(){
		return dao.getAllDestinations();
	}

}
