package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.WashType;
import airsponge.com.au.repository.WashTypeRepository;

@Service
@Transactional
public class WashTypeService {

	
	@Autowired
	private WashTypeRepository washTypeRepository;
	
	 
	public List<WashType> findAll(){
		
		return washTypeRepository.findAll();
	}


	public WashType findbyid(int id) {
		return washTypeRepository.findOne(id);
	}


	public void save(WashType washType) {
		washTypeRepository.save(washType);
		
	}
}
