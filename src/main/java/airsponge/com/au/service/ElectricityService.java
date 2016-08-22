package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.Electricity;
import airsponge.com.au.repository.ElectricityRepository;

@Service
@Transactional
public class  ElectricityService {
	
	@Autowired
	private ElectricityRepository electricityRepository;
	
	 
	public List<Electricity> findAll(){
		
		return electricityRepository.findAll();
	}


	public Electricity findbyid(int id) {
		return electricityRepository.findOne(id);
	}


	public void save(Electricity electricity) {
		electricityRepository.save(electricity);
		
	}
}
