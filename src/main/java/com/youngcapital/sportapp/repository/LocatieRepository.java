package com.youngcapital.sportapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youngcapital.sportapp.domain.Locatie;

@Repository
public interface LocatieRepository extends CrudRepository<Locatie, Long>{

}
