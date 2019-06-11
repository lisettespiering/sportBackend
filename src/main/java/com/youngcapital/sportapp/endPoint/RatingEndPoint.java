package com.youngcapital.sportapp.endPoint;

import java.util.ArrayList;
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
import com.youngcapital.sportapp.domain.Rating;
import com.youngcapital.sportapp.domain.Review;
import com.youngcapital.sportapp.domain.Sport;
import com.youngcapital.sportapp.service.AccountService;
import com.youngcapital.sportapp.service.LocatieService;
import com.youngcapital.sportapp.service.RatingService;
import com.youngcapital.sportapp.service.ReviewService;
import com.youngcapital.sportapp.service.SportService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping(
		value = "rating"
		, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		)

public class RatingEndPoint {
	@Autowired
	RatingService ratingService;
	
	@PostMapping("createRating")
	public ResponseEntity<Rating> apiCreate(@RequestBody Rating rating) { 

		return new ResponseEntity<Rating>(ratingService.save(rating), HttpStatus.OK);
	}
	
	@GetMapping("getRating/{id}")
	public ResponseEntity<Rating> getRating(@PathVariable long id) {
		Rating rating = null;
		Optional<Rating> oRating = ratingService.findById(id);
		if (oRating.isPresent()) {
			rating = oRating.get();
		} else {return new ResponseEntity<Rating>(HttpStatus.FORBIDDEN);}
		
		return new ResponseEntity<Rating>(ratingService.save(rating), HttpStatus.OK);
	}
	
	@PutMapping("updateRating/{id}")
	public ResponseEntity<Rating> updateLocatie(@PathVariable("id") long id, @RequestBody Rating rating) {
		Optional<Rating> oRating = ratingService.findById(id);
		Rating oldRating = null;
		if (oRating.isPresent()) {
			oldRating = oRating.get();
		} else {return new ResponseEntity<Rating>(HttpStatus.FORBIDDEN);}
		
		oldRating.setTotaal(rating.getTotaal());
		oldRating.setMoeilijkheid(rating.getMoeilijkheid());
		oldRating.setLocatie(rating.getLocatie());
		oldRating.setPersoneel(rating.getPersoneel());
		oldRating.setSfeer(rating.getSfeer());
		oldRating.setVariatie(rating.getVariatie());
		oldRating.setBereikbaarheid(rating.getBereikbaarheid());
		
		return new ResponseEntity<Rating>(ratingService.save(oldRating), HttpStatus.OK);
	}
	@DeleteMapping("DeleteRating/{id}")
	public ResponseEntity<Rating> DeleteRating(@PathVariable long id) {
		Optional<Rating> oRating = ratingService.findById(id);
		if (oRating.isPresent()) {
			ratingService.deleteById(id);
		} else {return new ResponseEntity<Rating>(HttpStatus.FORBIDDEN);}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
