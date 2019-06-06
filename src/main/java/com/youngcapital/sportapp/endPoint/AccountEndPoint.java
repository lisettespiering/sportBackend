package com.youngcapital.sportapp.endPoint;

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
import com.youngcapital.sportapp.domain.Sport;
import com.youngcapital.sportapp.service.AccountService;
import com.youngcapital.sportapp.service.ReviewService;
import com.youngcapital.sportapp.service.SportService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping(
		value = "account"
//		, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		)

public class AccountEndPoint {
	@Autowired
	AccountService accountService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	SportService sportService;

	@GetMapping("createAccount/{naam}/{wachtwoord}/{sportstring}/{woonplaats}/{email}")
	public ResponseEntity<Account> createAccount(@PathVariable String naam, @PathVariable String wachtwoord, @PathVariable String sportstring, @PathVariable String woonplaats, @PathVariable String email) {
		Iterable<Sport> iSport = sportService.findAll();
		Sport sport = null;
		for (Sport nSport : iSport) {
			if (nSport.getNaam().equalsIgnoreCase(sportstring) ) { 
				sport = nSport;
			}
		}
		
		if (sport == null) { return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST); }
		Account account = new Account(naam, wachtwoord, sport, woonplaats, email);
		return new ResponseEntity<Account>(accountService.save(account), HttpStatus.OK);
	}
	
	@GetMapping("UpdateAccount/{naam}/{wachtwoord}/{sportstring}/{woonplaats}/{email}/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable String naam, @PathVariable String wachtwoord, @PathVariable String sportstring, @PathVariable String woonplaats, @PathVariable String email, @PathVariable int id) {
		Account account;
		Optional<Account> oAccount = accountService.findById(id);
		if (oAccount.isPresent()) {
			account = oAccount.get();
		} else {return new ResponseEntity<Account>(HttpStatus.FORBIDDEN);}
		
		Iterable<Sport> iSport = sportService.findAll();
		Sport sport = null;
		for (Sport nSport : iSport) {
			if (nSport.getNaam().equalsIgnoreCase(sportstring) ) { 
				sport = nSport;
			}
		}
		if (sport == null) { return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST); }
		
		account.setEmail(email);
		account.setNaam(naam);
		account.setSport(sport);
		account.setWachtwoord(wachtwoord);
		account.setWoonplaats(woonplaats);
		
		return new ResponseEntity<Account>(accountService.save(account), HttpStatus.OK);
	}
	
	@GetMapping("getAccount/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable long id) {
		Account account = null;
		Optional<Account> oAccount = accountService.findById(id);
		if (oAccount.isPresent()) {
			account = oAccount.get();
		} else {return new ResponseEntity<Account>(HttpStatus.FORBIDDEN);}
		return new ResponseEntity<Account>(accountService.save(account), HttpStatus.OK);
	}	
}
