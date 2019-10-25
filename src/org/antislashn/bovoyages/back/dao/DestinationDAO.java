package org.antislashn.bovoyages.back.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.antislashn.bovoyages.back.entities.DatesVoyage;
import org.antislashn.bovoyages.back.entities.Destination;

public class DestinationDAO extends AbstractDAO<Destination, Long> {

	public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
	}

	public List<Destination> getAllDestinations() {
		EntityManager em = getEMF().createEntityManager();
		List<Destination> destinations = em.createNamedQuery("Destination.All",Destination.class)
											.getResultList();
		em.close();
		return destinations;
	}

	public List<String> getAllRegions() {
		EntityManager em = getEMF().createEntityManager();
		List<String> regions = em.createNamedQuery("Destination.AllRegions",String.class)
											.getResultList();
		em.close();
		return regions;
	}

	public List<DatesVoyage> getDatesVoyagesByIdDestination(long id) {
		EntityManager em = getEMF().createEntityManager();
		Destination destination = em.find(Destination.class, id);
		List<DatesVoyage> datesVoyages = new ArrayList<>();
		for(DatesVoyage dv : destination.getDatesVoyages()) {
			datesVoyages.add(dv);
		}
		em.close();
		return datesVoyages;
	}

}
