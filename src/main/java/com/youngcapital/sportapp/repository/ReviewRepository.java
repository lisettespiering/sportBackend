package com.youngcapital.sportapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youngcapital.sportapp.domain.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

}
