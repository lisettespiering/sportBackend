package com.youngcapital.sportapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youngcapital.sportapp.domain.Sport;

@Repository
public interface SportRepository extends CrudRepository<Sport, Long>{

}
