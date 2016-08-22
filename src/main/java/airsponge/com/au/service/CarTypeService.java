package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.CarType;
import airsponge.com.au.repository.CarTypeRepository;


@Service
@Transactional
public class  CarTypeService {

	
	@Autowired
	private CarTypeRepository carTypeRepository;
	
	 
	public List<CarType> findAll(){
		
		return carTypeRepository.findAll();
	}


	public CarType findbyid(int id) {
		return carTypeRepository.findOne(id);
	}


	public void save(CarType carType) {
		carTypeRepository.save(carType);
		
	}
}