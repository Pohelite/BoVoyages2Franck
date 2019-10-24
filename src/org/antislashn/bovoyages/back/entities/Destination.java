package org.antislashn.bovoyages.back.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destinations")
@Access(AccessType.FIELD)
@NamedQuery(name = "Destination.All",query = "SELECT d FROM Destination d")
@NamedQuery(name = "Destination.AllRegions",query = "SELECT DISTINCT d.region FROM Destination d")
public class Destination implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_destination")
	private long id;
	private String region;
	private String description;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="images",joinColumns = @JoinColumn(name="fk_destination"))
	@Column(name="image")
	private List<String> images = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_destination")
	public List<DatesVoyage> datesVoyages = new ArrayList<>();
	
	public void addImageFileName(String fileName) {
		images.add(fileName);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<DatesVoyage> getDatesVoyages() {
		return datesVoyages;
	}

	public void setDatesVoyages(List<DatesVoyage> datesVoyages) {
		this.datesVoyages = datesVoyages;
	}
	
	
}
