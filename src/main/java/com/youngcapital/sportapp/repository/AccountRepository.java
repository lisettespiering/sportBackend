package com.youngcapital.sportapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youngcapital.sportapp.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
