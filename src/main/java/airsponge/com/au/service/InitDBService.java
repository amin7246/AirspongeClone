package airsponge.com.au.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.Address;
import airsponge.com.au.entity.User;
import airsponge.com.au.entity.Washee;
import airsponge.com.au.repository.UserRepository;
import airsponge.com.au.repository.WasheeRepository;


@Transactional
@Service
public class InitDBService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WasheeRepository washeeRepository;
	
	@PostConstruct
	public void init() {
		
	/*
		User newUser = new User();
		newUser.setId(1);
		newUser.setFirstName("amin");
		newUser.setPhone("7246");
		userRepository.save(newUser);
		
		Washee newWashee = new Washee();
		newWashee.setId(1);
		newWashee.setUser(newUser);
		washeeRepository.save(newWashee);
	
		
		*/
		/*
		Washee newWashee = new Washee();
		newWashee.setCarType("limoozin");
		newWashee.setLocationPostCode("4101");
		newWashee.setMaxprice(20.0);
		newWashee.setUser(newUser);
		washeeRepository.save(newWashee);

		Washer newWasher = new Washer();
		newWasher.setLocationPostCode("4101");
		newWasher.setUser(newUser);
		newWasher.setMinPrice(30.0);
		newWasher.setTravelDistance(1);
		washerRepository.save(newWasher);  */

	}

}
