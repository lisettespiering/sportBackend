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
import com.youngcapital.sportapp.service.ReviewService;
import com.youngcapital.sportapp.service.SportService;

@RestController 
@RequestMapping(
		value = "sport"
//		, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		)


public class SportEndPoint {
	@Autowired
	SportService sportService;
	
	@GetMapping("getSport/{id}")
	public ResponseEntity<Sport> getLocatie(@PathVariable long id) {
		Sport sport = null;
		Optional<Sport> oSport = sportService.findById(id);
		if (oSport.isPresent()) {
			sport = oSport.get();
		} else {return new ResponseEntity<Sport>(HttpStatus.FORBIDDEN);}
		return new ResponseEntity<Sport>(sportService.save(sport), HttpStatus.OK);
	}


	@PostMapping("createSport")
	public ResponseEntity<Sport> apiCreate(@RequestBody Sport sport) { //@RequestBody String naam, @RequestBody String adres, @RequestBody String sportstring) {

		return new ResponseEntity<Sport>(sportService.save(sport), HttpStatus.OK);
	}
	
	@PutMapping("updateSport/{id}")
	public ResponseEntity<Sport> updateLocatie(@PathVariable("id") long id, @RequestBody Sport sport) {
		Optional<Sport> oSport = sportService.findById(id);
		Sport oldSport = null;
		if (oSport.isPresent()) {
			oldSport = oSport.get();
		} else {return new ResponseEntity<Sport>(HttpStatus.FORBIDDEN);}
		
		sport.setNaam(sport.getNaam());
		return new ResponseEntity<Sport>(sportService.save(oldSport), HttpStatus.OK);
	}

	@DeleteMapping("deleteSport/{id}")
	public ResponseEntity<Sport> deleteSport(@PathVariable long id) {
		Optional<Sport> oSport = sportService.findById(id);
		if (oSport.isPresent()) {
			sportService.deleteById(id);
		} else {return new ResponseEntity<>(HttpStatus.FORBIDDEN);}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}


