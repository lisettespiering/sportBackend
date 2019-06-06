package com.youngcapital.sportapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youngcapital.sportapp.domain.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{

}
