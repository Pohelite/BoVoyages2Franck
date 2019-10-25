package org.antislashn.bovoyages.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author franck
 *
 */
@Entity
@Table(name="dates_voyages")
@Access(AccessType.FIELD)
public class DatesVoyage implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_date_voyage")
	private long id;
	@Column(name = "date_depart")
	private Date dateAller;
	@Column(name = "date_retour")
	private Date dateRetour;
	private double prixHT;
	@Column(name = "nb_places")
	private int nbPlaces;
	@Column(name = "deleted")
	private boolean raye;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateAller() {
		return dateAller;
	}
	public void setDateAller(Date dateAller) {
		this.dateAller = dateAller;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	public double getPrixHT() {
		return prixHT;
	}
	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPLaces) {
		this.nbPlaces = nbPLaces;
	}
	public boolean isRaye() {
		return raye;
	}
	public void setRaye(boolean raye) {
		this.raye = raye;
	}
	
	

}
