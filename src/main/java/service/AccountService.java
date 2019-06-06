package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youngcapital.sportapp.domain.Account;
import com.youngcapital.sportapp.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepository AccountRepository;
	
	public Account save(Account account) {
		return AccountRepository.save(account);
		}
		public Optional<Account> findById(long id) {
		return AccountRepository.findById(id);
		}
		public Iterable<Account> findAll() {
		return AccountRepository.findAll();
		}
		public void deleteById(long id) {
		AccountRepository.deleteById(id);
		}

}
