package airsponge.com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.User;
import airsponge.com.au.entity.Washer;
import airsponge.com.au.repository.WasherRepository;

@Service
public class WasherService {

	
	@Autowired
	private WasherRepository washerRepository;
	
	 
	public List<Washer> findAll(){
		
		return washerRepository.findAll();
	}


	public Washer findbyid(int id) {
		return washerRepository.findOne(id);
	}
	
	public Washer findbyuser(User user) {
		return washerRepository.findByUser(user);
	}


	public void save(Washer washer) {
		washerRepository.save(washer);
		
	}
}
