package com.youngcapital.sportapp.endPoint;

import java.util.Optional;

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
	
	@PostMapping("createLocatie")
	public ResponseEntity<Locatie> apiCreate(@RequestBody Locatie locatie) { 
		//@RequestBody String naam, @RequestBody String adres, @RequestBody String sportstring) {
//		Sport sport = null;
//		System.out.println(sport);
		return new ResponseEntity<Locatie>(locatieService.save(locatie), HttpStatus.OK);
	}
	
	@PutMapping("updateLocatie/{id}")
	public ResponseEntity<Locatie> updateLocatie(@PathVariable("id") long id, @RequestBody Locatie locatie) {
		Optional<Locatie> oLocatie = locatieService.findById(id);
		Locatie oldLocatie = null;
		if (oLocatie.isPresent()) {
			oldLocatie = oLocatie.get();
		} else {return new ResponseEntity<Locatie>(HttpStatus.FORBIDDEN);}
		
		oldLocatie.setAdres(locatie.getAdres());
		oldLocatie.setNaam(locatie.getNaam());
		oldLocatie.setSport(locatie.getSport());
		
		return new ResponseEntity<Locatie>(locatieService.save(oldLocatie), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteLocatie/{id}")
	public ResponseEntity<Locatie> deleteLocatie(@PathVariable("id") long id) {

		Optional<Locatie> oLocatie = locatieService.findById(id);
		if (oLocatie.isPresent()) {
			locatieService.deleteById(id);
		} else {return new ResponseEntity<Locatie>(HttpStatus.FORBIDDEN);}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("getLocatie/{id}")
	public ResponseEntity<Locatie> getLocatie(@PathVariable long id) {
		Locatie locatie = null;
		Optional<Locatie> oLocatie = locatieService.findById(id);
		if (oLocatie.isPresent()) {
			locatie = oLocatie.get();
		} else {return new ResponseEntity<Locatie>(HttpStatus.FORBIDDEN);}
		return new ResponseEntity<Locatie>(locatieService.save(locatie), HttpStatus.OK);
	}
	
}
