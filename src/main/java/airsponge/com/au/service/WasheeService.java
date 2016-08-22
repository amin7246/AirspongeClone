package airsponge.com.au.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.User;
import airsponge.com.au.entity.Washee;
import airsponge.com.au.repository.WasheeRepository;

@Service
public class WasheeService {

	
	@Autowired
	private WasheeRepository washeeRepository;
	
	public Washee findbyuser(User user) {
		return washeeRepository.findByUser(user);
	}

	public void save(Washee washee) {
		washeeRepository.save(washee);
		
	}
}
