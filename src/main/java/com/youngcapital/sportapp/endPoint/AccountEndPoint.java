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
import com.youngcapital.sportapp.domain.Locatie;
import com.youngcapital.sportapp.domain.Sport;
import com.youngcapital.sportapp.service.AccountService;
import com.youngcapital.sportapp.service.ReviewService;
import com.youngcapital.sportapp.service.SportService;
import com.youngcapital.sportapp.tools.Hashww;

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

	@PostMapping("createAccount")
	public ResponseEntity<Account> apiCreate(@RequestBody Account account) { //@RequestBody String naam, @RequestBody String adres, @RequestBody String sportstring) {

		Optional<Account> oAccount = accountService.findByEmail(account.getEmail());
		
		account.setWachtwoord(Hashww.md5(account.getWachtwoord()));
		
		if (oAccount.isPresent() ) {
			return new ResponseEntity<Account>(HttpStatus.CONFLICT);
		} 
		
		return new ResponseEntity<Account>(accountService.save(account), HttpStatus.OK);
	}
	
	@PutMapping("updateAccount/{id}")
	public ResponseEntity<Account> updateLocatie(@PathVariable("id") long id, @RequestBody Account account) {
		
		account.setWachtwoord(Hashww.md5(account.getWachtwoord()));
		
		Optional<Account> oAccount = accountService.findById(id);
		Account oldAccount = null;
		if (oAccount.isPresent()) {
			oldAccount = oAccount.get();
		} else {return new ResponseEntity<Account>(HttpStatus.FORBIDDEN);}
		
		oldAccount.setNaam(account.getNaam());
		oldAccount.setWachtwoord(account.getWachtwoord());
		oldAccount.setSport(account.getSport());
		oldAccount.setWoonplaats(account.getWoonplaats());
		oldAccount.setEmail(account.getEmail());

		return new ResponseEntity<Account>(accountService.save(oldAccount), HttpStatus.OK);
	}
	
	@PutMapping("login") 
	public ResponseEntity<Account> login(@RequestBody Account account) {
		
		account.setWachtwoord(Hashww.md5(account.getWachtwoord()));
		
		Optional<Account> oAccount = accountService.findByEmail(account.getEmail());
		Account oldAccount = null;
		if (oAccount.isPresent() 
				&& oAccount.get().getWachtwoord().equals(account.getWachtwoord())) {
			oldAccount = oAccount.get();
		} else {return new ResponseEntity<Account>(HttpStatus.UNAUTHORIZED);}
		
		return new ResponseEntity<Account>(oldAccount, HttpStatus.OK);
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
	
	@DeleteMapping("DeleteAccount/{id}")
	public ResponseEntity<Account> DeleteAccount(@PathVariable long id) {
		Optional<Account> oAccount = accountService.findById(id);
		if (oAccount.isPresent()) {
			accountService.deleteById(id);
		} else {return new ResponseEntity<Account>(HttpStatus.FORBIDDEN);}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
