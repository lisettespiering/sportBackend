package com.youngcapital.sportapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Locatie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String naam;
	private String adres;
	@ManyToOne
	private Sport sport;
//	@OneToMany
//	private Set<Review>reviews;
	
	public Locatie() {};
	public Locatie(String naam, String adres, Sport sport) {
		this.naam = naam;
		this.adres = adres;
		this.sport = sport;
//		this.reviews = new HashSet<Review>();
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
//	public Set<Review> getReviews() {
//		return reviews;
//	}
//	public void setReviews(Set<Review> reviews) {
//		this.reviews = reviews;
//	}
	public Long getId() {
		return id;
	}

}
