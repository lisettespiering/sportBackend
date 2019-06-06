package com.youngcapital.sportapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	private int totaal;
	private int moeilijkheid ;
	private int locatie;
	private int personeel;
	private int sfeer;
	private int variatie;
	private int bereikbaarheid;
//	private int gemiddeld;
//	private int[] rating = new int[8];
	
Rating(){
		
}
Rating(int totaal, int moeilijkheid, int locatie, int personeel, int sfeer, int variatie, int bereikbaarheid){
	this.totaal = totaal;
	this.moeilijkheid = moeilijkheid;
	this.locatie = locatie;
	this.personeel = personeel;
	this.sfeer = sfeer;
	this.variatie = variatie;
	this.bereikbaarheid = bereikbaarheid;
	
}

int getGemiddeld() {
	int gemiddeld = (totaal + moeilijkheid + locatie + personeel + sfeer + variatie + bereikbaarheid)/7;
	return gemiddeld;
}
}