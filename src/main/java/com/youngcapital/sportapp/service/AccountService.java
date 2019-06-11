package com.youngcapital.sportapp.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youngcapital.sportapp.domain.Account;
import com.youngcapital.sportapp.domain.Locatie;
import com.youngcapital.sportapp.domain.Rating;
import com.youngcapital.sportapp.domain.Review;
import com.youngcapital.sportapp.domain.Sport;
import com.youngcapital.sportapp.repository.AccountRepository;
import com.youngcapital.sportapp.repository.LocatieRepository;
import com.youngcapital.sportapp.repository.RatingRepository;
import com.youngcapital.sportapp.repository.ReviewRepository;
import com.youngcapital.sportapp.repository.SportRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private SportRepository sportRepository;

	@Autowired
	private LocatieRepository locatieRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	public Optional<Account> findById(long id) {
		return accountRepository.findById(id);
	}

	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}

	public void deleteById(long id) {
		accountRepository.deleteById(id);
	}
	
	@PostConstruct
	public void initPersonen() {
		Sport duiken = sportRepository.save(new Sport("Duiken"));
		Sport boulderen = sportRepository.save(new Sport("Boulderen"));
		
		Account john  = accountRepository.save(new Account("John", "john", duiken, "Amsterdam", "email"));
		Account klaas = accountRepository.save(new Account("Klaas", "klaas", boulderen, "Rotterdam", "email"));
		
		Locatie elphinstone = locatieRepository.save(new Locatie("Elphinstone", "Marsa Alam" , duiken));
		Locatie monk = locatieRepository.save(new Locatie("Monk", "Eindhoven" , duiken));
		
		Rating rating1 = ratingRepository.save(new Rating(1, 2, 3, 4, 5, 6, 7));
		Rating rating2 = ratingRepository.save(new Rating(2, 2, 2, 2, 2, 2, 2));
			
		reviewRepository.save(new Review(john, "Mijn Review", "Mijn inhoud", rating1, null,elphinstone));
		reviewRepository.save(new Review(klaas, "KlaasReview", "Klasinhoud", rating2, null,monk));
		
	}

}
