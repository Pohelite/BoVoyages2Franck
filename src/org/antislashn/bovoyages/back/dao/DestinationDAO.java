package org.antislashn.bovoyages.back.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

}
