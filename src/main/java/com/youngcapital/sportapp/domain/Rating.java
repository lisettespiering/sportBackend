package com.youngcapital.sportapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int totaal;
	private int moeilijkheid ;
	private int locatie;
	private int personeel;
	private int sfeer;
	private int variatie;
	private int bereikbaarheid;
//	private int gemiddeld;
//	private int[] rating = new int[8];
	
public Rating(){
		
}
public Rating(int totaal, int moeilijkheid, int locatie, int personeel, int sfeer, int variatie, int bereikbaarheid){
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
public int getTotaal() {
	return totaal;
}
public void setTotaal(int totaal) {
	this.totaal = totaal;
}
public int getMoeilijkheid() {
	return moeilijkheid;
}
public void setMoeilijkheid(int moeilijkheid) {
	this.moeilijkheid = moeilijkheid;
}
public int getLocatie() {
	return locatie;
}
public void setLocatie(int locatie) {
	this.locatie = locatie;
}
public int getPersoneel() {
	return personeel;
}
public void setPersoneel(int personeel) {
	this.personeel = personeel;
}
public int getSfeer() {
	return sfeer;
}
public void setSfeer(int sfeer) {
	this.sfeer = sfeer;
}
public int getVariatie() {
	return variatie;
}
public void setVariatie(int variatie) {
	this.variatie = variatie;
}
public int getBereikbaarheid() {
	return bereikbaarheid;
}
public void setBereikbaarheid(int bereikbaarheid) {
	this.bereikbaarheid = bereikbaarheid;
}
public Long getId() {
	return id;
}


}