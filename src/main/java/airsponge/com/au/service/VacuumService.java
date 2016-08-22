package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.Vacuum;
import airsponge.com.au.repository.VacuumRepository;


@Service
@Transactional
public class  VacuumService {

	
	@Autowired
	private VacuumRepository vacuumRepository;
	
	 
	public List<Vacuum> findAll(){
		
		return vacuumRepository.findAll();
	}


	public Vacuum findbyid(int id) {
		return vacuumRepository.findOne(id);
	}


	public void save(Vacuum vacuum) {
		vacuumRepository.save(vacuum);
		
	}
}
