package com.youngcapital.sportapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youngcapital.sportapp.domain.Rating;
//import com.youngcapital.sportapp.repository.AccountRepository;
import com.youngcapital.sportapp.repository.RatingRepository;

@Service
@Transactional
public class RatingService {
	
	@Autowired
	private  RatingRepository RatingRepository;
	
	public Rating save(Rating rating) {
		return RatingRepository.save(rating);
		}
		public Optional<Rating> findById(long id) {
		return RatingRepository.findById(id);
		}
		public Iterable<Rating> findAll() {
		return RatingRepository.findAll();
		}
		public void deleteById(long id) {
		RatingRepository.deleteById(id);
		}

}
