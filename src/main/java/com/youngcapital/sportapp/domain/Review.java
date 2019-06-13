package com.youngcapital.sportapp.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Account account;
	private String titel;
	private String inhoud;
	@ManyToOne
	private Rating rating;
	private ArrayList<String> bijzonderheden;
	@ManyToOne
	private Locatie locatie;
	
	Review() {}
	
	public Review(Account account, String titel, String inhoud, Rating rating, ArrayList<String> bijzonderheden,
			Locatie locatie) {
		super();
		this.account = account;
		this.titel = titel;
		this.inhoud = inhoud;
		this.rating = rating;
		this.bijzonderheden = bijzonderheden;
		this.locatie = locatie;
	}


	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getInhoud() {
		return inhoud;
	}
	public void setInhoud(String inhoud) {
		this.inhoud = inhoud;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public ArrayList<String> getBijzonderheden() {
		return bijzonderheden;
	}
	public void setBijzonderheden(ArrayList<String> bijzonderheden) {
		this.bijzonderheden = bijzonderheden;
	}
	public Locatie getLocatie() {
		return locatie;
	}
	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}
	public Long getId() {
		return id;
	}
	
	

}
