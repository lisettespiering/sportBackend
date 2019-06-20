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

@RestController 
@RequestMapping(
		value = "review"
		, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		)

public class ReviewEndPoint {
	@Autowired
	ReviewService reviewService;
	@Autowired
	AccountService accountService;
	@Autowired
	LocatieService locatieService;
	@Autowired
	RatingService ratingService;
	@Autowired
	SportService sportService;
	
	
	@PostMapping("createReview")
	public ResponseEntity<Review> apiCreate(@RequestBody Review review) { 

		return new ResponseEntity<Review>(reviewService.save(review), HttpStatus.OK);
	}
	
	@GetMapping("getReview/{id}")
	public ResponseEntity<Review> getReview(@PathVariable long id) {
		Review review = null;
		Optional<Review> oReview = reviewService.findById(id);
		if (oReview.isPresent()) {
			review = oReview.get();
		} else {return new ResponseEntity<Review>(HttpStatus.FORBIDDEN);}
		
		return new ResponseEntity<Review>(reviewService.save(review), HttpStatus.OK);
	}
	
	@GetMapping("getReviewsIds/{id}")
	public ResponseEntity<Iterable<Review>> getReviewIds(@PathVariable long id) {
		
		return new ResponseEntity<Iterable<Review>>(reviewService.selectByLocationId(id), HttpStatus.OK);
	}
	
	@PutMapping("updateReview/{id}")
	public ResponseEntity<Review> updateLocatie(@PathVariable("id") long id, @RequestBody Review review) {
		Optional<Review> oReview = reviewService.findById(id);
		Review oldReview = null;
		if (oReview.isPresent()) {
			oldReview = oReview.get();
		} else {return new ResponseEntity<Review>(HttpStatus.FORBIDDEN);}
		
		oldReview.setTitel(review.getTitel());
		oldReview.setInhoud(review.getInhoud());
		oldReview.setBijzonderheden(review.getBijzonderheden());
		
		return new ResponseEntity<Review>(reviewService.save(oldReview), HttpStatus.OK);
	}
	
	@DeleteMapping("DeleteReview/{id}")
	public ResponseEntity<Review> DeleteReview(@PathVariable long id) {
		
		Optional<Review> oReview = reviewService.findById(id);
		if (oReview.isPresent()) {
			reviewService.deleteById(id);
		} else {return new ResponseEntity<Review>(HttpStatus.FORBIDDEN);}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("getReview") 	// Retrieve
	public ResponseEntity<Iterable<Review>> apiGetAll() {
		return new ResponseEntity<Iterable<Review>>(
				reviewService.findAll(), 
				HttpStatus.OK);
	}
	@GetMapping("getReviewByUser/{id}") 	// Retrieve
	public ResponseEntity<Iterable<Review>> getbyUser(@PathVariable long id) {
		return new ResponseEntity<Iterable<Review>>(
				reviewService.findByUser(id), 
				HttpStatus.OK);
	}
}