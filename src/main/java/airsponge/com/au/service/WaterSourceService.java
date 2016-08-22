package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.WaterSource;
import airsponge.com.au.repository.WaterSourceRepository;



@Service
@Transactional
public class WaterSourceService {

	
	@Autowired
	private WaterSourceRepository waterSourceRepository;
	
	 
	public List<WaterSource> findAll(){
		
		return waterSourceRepository.findAll();
	}


	public WaterSource findbyid(int id) {
		return waterSourceRepository.findOne(id);
	}


	public void save(WaterSource waterSource) {
		waterSourceRepository.save(waterSource);
		
	}
}
