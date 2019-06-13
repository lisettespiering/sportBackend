package com.youngcapital.sportapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String naam;
	
	public Sport() {};
	public Sport(String naam) {
		this.naam = naam;
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
		
}
