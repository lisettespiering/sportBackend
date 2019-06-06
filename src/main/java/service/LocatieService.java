package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youngcapital.sportapp.domain.Locatie;
import com.youngcapital.sportapp.repository.LocatieRepository;

@Service
@Transactional
public class LocatieService {

	@Autowired
	private LocatieRepository LocatieRepository;
	
	public Locatie save(Locatie locatie) {
		return LocatieRepository.save(locatie);
		}
		public Optional<Locatie> findById(long id) {
		return LocatieRepository.findById(id);
		}
		public Iterable<Locatie> findAll() {
		return LocatieRepository.findAll();
		}
		public void deleteById(long id) {
		LocatieRepository.deleteById(id);
		}
}
