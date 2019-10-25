package org.antislashn.bovoyages.back.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.antislashn.bovoyages.back.entities.DatesVoyage;

public class DatesVoyageDAO extends AbstractDAO<DatesVoyage, Long>{

	public DatesVoyageDAO(EntityManagerFactory emf) {
		super(emf, DatesVoyage.class);
	}
	
	public void delete(List<DatesVoyage> datesVoyages) {
		for(DatesVoyage dv : datesVoyages) {
			delete(dv.getId());
		}
	}

}
