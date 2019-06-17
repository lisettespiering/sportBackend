package com.youngcapital.sportapp.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youngcapital.sportapp.domain.Review;
import com.youngcapital.sportapp.repository.ReviewRepository;

@Service
@Transactional
public class ReviewService {

	@Autowired
	private ReviewRepository ReviewRepository;
	
	public Review save(Review review) {
		return ReviewRepository.save(review);
		}
		public Optional<Review> findById(long id) {
		return ReviewRepository.findById(id);
		}
		public Iterable<Review> findAll() {
		return ReviewRepository.findAll();
		}
		public void deleteById(long id) {
		ReviewRepository.deleteById(id);
		}
		public Iterable<Review> selectByLocationId(long id) {
			Iterable<Review> locations = ReviewRepository.findAll();
			ArrayList<Review> ar = new ArrayList<Review>();
			for(Review i:locations) {
				if(i.getLocatie().getId()==id) {
					ar.add(i);
				}
			}
			Iterable<Review> chosenReviews = ar;
			return chosenReviews;
		}
}
