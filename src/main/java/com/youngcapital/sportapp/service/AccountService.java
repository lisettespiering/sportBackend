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
		Account sam = accountRepository.save(new Account("Sam", "abdgs", boulderen, "Vlissingen", "samvisser@gmail.com"));
		Account Maria = accountRepository.save(new Account("Maria", "dgs", duiken, "Harlingen", "mariagonzales@gmail.mx"));
		
		Locatie elphinstone = locatieRepository.save(new Locatie("Elphinstone", "Marsa Alam" , duiken));
		Locatie monk = locatieRepository.save(new Locatie("Monk", "Eindhoven" , duiken));
		locatieRepository.save(new Locatie("Sterk", "Utrecht" , boulderen));
		locatieRepository.save(new Locatie("Impact", "Almere" , boulderen));
		locatieRepository.save(new Locatie("Kei", "Amersfoort" , boulderen));
		locatieRepository.save(new Locatie("Het Lab", "Amersfoort" , boulderen));
		locatieRepository.save(new Locatie("Monk", "Amsterdam" , boulderen));
		locatieRepository.save(new Locatie("RijnBoulder", "Arnhem" , boulderen));
		locatieRepository.save(new Locatie("Bruut", "Breda" , boulderen));
		locatieRepository.save(new Locatie("Delfts Bleau", "Delft" , boulderen));
		locatieRepository.save(new Locatie("Bosche Boulders", "Den Bosch" , boulderen));
		locatieRepository.save(new Locatie("Boulderwerk", "Den Haag" , boulderen));
		locatieRepository.save(new Locatie("De Campus", "Den Haag" , boulderen));
		locatieRepository.save(new Locatie("Cube", "Enschede" , boulderen));
		locatieRepository.save(new Locatie("Gropo", "Groningen" , boulderen));
		locatieRepository.save(new Locatie("De Fabriek", "Haarlem" , boulderen));
		locatieRepository.save(new Locatie("Kunststof", "Leiden" , boulderen));
		locatieRepository.save(new Locatie("Radium", "Maastricht" , boulderen));
		locatieRepository.save(new Locatie("Grip", "Nijmegen" , boulderen));
		locatieRepository.save(new Locatie("Neoliet", "Rotterdam" , boulderen));
		locatieRepository.save(new Locatie("Monk", "Rotterdam" , boulderen));
		locatieRepository.save(new Locatie("Graviton", "Sittard" , boulderen));
		locatieRepository.save(new Locatie("Block2013", "Tilburg" , boulderen));
		locatieRepository.save(new Locatie("Energiehaven", "Utrecht" , boulderen));
		locatieRepository.save(new Locatie("Anna Jacobapolder", "Bruinisse" , duiken));
		locatieRepository.save(new Locatie("Aquabest", "Eindhoven" , duiken));
		locatieRepository.save(new Locatie("Plaat van Oude Tonge", "Bruinisse" , duiken));
		locatieRepository.save(new Locatie("Bergse Diepsluis Hangcultuur", "Tholen" , duiken));
		locatieRepository.save(new Locatie("Bergse Diepsluis Oesterdam", "Tholen" , duiken));
		locatieRepository.save(new Locatie("Vinkeveense Plassen", "Vinkeveen" , duiken));
		locatieRepository.save(new Locatie("Silfra", "Þingvellir" , duiken));
		locatieRepository.save(new Locatie("Marsa Shagra", "Marsa Alam" , duiken));
		locatieRepository.save(new Locatie("Marsa Nakiri", "Marsa Alam" , duiken));
		locatieRepository.save(new Locatie("Abu Dabbab Long Canyon", "Marsa Alam" , duiken));
		locatieRepository.save(new Locatie("Shaab Abu Dabbab", "Marsa Alam" , duiken));
		locatieRepository.save(new Locatie("Sharm Abu Dabbab", "Marsa Alam" , duiken));
		locatieRepository.save(new Locatie("Shaab Marsa Alam", "Marsa Alam" , duiken));
		locatieRepository.save(new Locatie("Cham Island", "Hội An" , duiken));
		locatieRepository.save(new Locatie("Boschmolenplas ", "Panheel" , duiken));
		locatieRepository.save(new Locatie("De Beldert", "Zoelen" , duiken));
		locatieRepository.save(new Locatie("Junker 88A-2 Duitse bommenwerper", "Dishoek", duiken));
		locatieRepository.save(new Locatie("Blue Hole", "Abu Galum", duiken));
		
		Rating rating1 = ratingRepository.save(new Rating(1, 2, 3, 4, 5, 6, 7));
		Rating rating2 = ratingRepository.save(new Rating(2, 2, 2, 2, 2, 2, 2));
			
		reviewRepository.save(new Review(john, "Mijn Review", "Elphinstone is leuk!", rating1, null,elphinstone));
		reviewRepository.save(new Review(klaas, "KlaasReview", "Monk is fantastisch", rating2, null,monk));
//		reviewRepository.save(new Review(sam, "Sams Review", "Fijne sportclub, rustig en goed bereikbaar", rating2, null,sterk));
		
	}

}
