package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.BankAccount;
import airsponge.com.au.repository.BankaccountRepository;

@Service
@Transactional
public class BankaccountService {

	
	@Autowired
	private BankaccountRepository bankaccountRepository;
	
	 
	public List<BankAccount> findAll(){
		
		return bankaccountRepository.findAll();
	}


	public BankAccount findbyid(int id) {
		return bankaccountRepository.findOne(id);
	}


	public void save(BankAccount bankacc) {
		bankaccountRepository.save(bankacc);
		
	}
}
