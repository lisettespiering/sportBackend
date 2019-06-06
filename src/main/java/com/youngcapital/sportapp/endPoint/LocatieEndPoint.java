package com.youngcapital.sportapp.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youngcapital.sportapp.domain.Account;
import com.youngcapital.sportapp.domain.Locatie;
import com.youngcapital.sportapp.domain.Sport;
import com.youngcapital.sportapp.service.AccountService;
import com.youngcapital.sportapp.service.LocatieService;
import com.youngcapital.sportapp.service.ReviewService;
import com.youngcapital.sportapp.service.SportService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping(
		value = "locatie"
//		, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		)


public class LocatieEndPoint {
	@Autowired
	ReviewService reviewService;
	@Autowired
	SportService sportService;
	@Autowired
	LocatieService locatieService;
	
	@GetMapping("createLocatie/{naam}/{adres}/{sportstring}")
	public ResponseEntity<Locatie> createLocatie(@PathVariable String naam, @PathVariable String adres, @PathVariable String sportstring) {
		Iterable<Sport> iSport = sportService.findAll();
		Sport sport = null;
		for (Sport nSport : iSport) {
			if (nSport.getNaam().equalsIgnoreCase(sportstring) ) { 
				sport = nSport;
			}
		}
		
		if (sport == null) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		
		Locatie locatie = new Locatie(naam, adres, sport);
		return new ResponseEntity<Locatie>(locatieService.save(locatie), HttpStatus.OK);
	}
	
	
}