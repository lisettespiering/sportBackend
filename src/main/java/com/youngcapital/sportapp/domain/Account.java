package com.youngcapital.sportapp.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String naam;
	private String wachtwoord;
	@ManyToOne
	private Sport sport;
	private ArrayList<String> favorietePlekken;
	private String woonplaats;
	private int aanmaakdatum;
	@Column(unique=true)
	private String email;
//	@OneToMany
//	private Set<Review>reviews;
	
	public Account() {}
	public Account(String naam, String watchwoord, Sport sport, String woonplaats, String email) {
		this.naam = naam;
		this.wachtwoord = watchwoord;
		this.sport = sport;
		this.woonplaats = woonplaats;
		this.email = email;
		this.aanmaakdatum = 20190101;
		this.favorietePlekken = new ArrayList<>();
//		this.reviews = new HashSet<Review>();
	}
	
//	public Set<Review> getReviews() {
//		return reviews;
//	}
//	public void setReviews(Set<Review> reviews) {
//		this.reviews = reviews;
//	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	public ArrayList<String> getFavorietePlekken() {
		return favorietePlekken;
	}
	public void setFavorietePlekken(ArrayList<String> favorietePlekken) {
		this.favorietePlekken = favorietePlekken;
	}
	public String getWoonplaats() {
		return woonplaats;
	}
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
//	public int getAantalReviews() {
//		return reviews.size();
//	}
	public int getAanmaakdatum() {
		return aanmaakdatum;
	}
	public void setAanmaakdatum(int aanmaakdatum) {
		this.aanmaakdatum = aanmaakdatum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	
}