package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.WashStatus;
import airsponge.com.au.repository.WashStatusRepository;

@Service
@Transactional
public class WashStatusService {

	
	@Autowired
	private WashStatusRepository washStatusRepository;
	
	 
	public List<WashStatus> findAll(){
		
		return washStatusRepository.findAll();
	}


	public WashStatus findbyid(int id) {
		return washStatusRepository.findOne(id);
	}


	public void save(WashStatus washStatus) {
		washStatusRepository.save(washStatus);
		
	}
}
