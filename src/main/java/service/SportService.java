package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youngcapital.sportapp.domain.Sport;
import com.youngcapital.sportapp.repository.SportRepository;

@Service
@Transactional
public class SportService {

	@Autowired
	private SportRepository SportRepository;
	
	public Sport save(Sport sport) {
		return SportRepository.save(sport);
		}
		public Optional<Sport> findById(long id) {
		return SportRepository.findById(id);
		}
		public Iterable<Sport> findAll() {
		return SportRepository.findAll();
		}
		public void deleteById(long id) {
		SportRepository.deleteById(id);
		}
}
