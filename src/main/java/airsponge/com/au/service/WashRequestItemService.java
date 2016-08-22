package airsponge.com.au.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.WashRequest;
import airsponge.com.au.entity.WashRequestItem;
import airsponge.com.au.entity.Washer;
import airsponge.com.au.repository.WashRequestItemRepository;

@Service
@Transactional
public class WashRequestItemService {

	@Autowired
	private WashRequestItemRepository washRequestItemRepository;

	public List<WashRequestItem> findAll() {
		return washRequestItemRepository.findAll();
	}

	public List<WashRequestItem> findAllPendingWash() {
		return washRequestItemRepository.findByWasherIsNull();
	}

	public List<WashRequestItem> findbyWashRequest(WashRequest washRequest) {
		return washRequestItemRepository.findByWashRequest(washRequest);
	}

	public List<WashRequestItem> findbywasher(Washer washer) {
		return washRequestItemRepository.findByWasher(washer);
	}

	public WashRequestItem findbyid(int id) {
		return washRequestItemRepository.findOne(id);
	}

	public void save(WashRequestItem washRequestItem) {
		washRequestItemRepository.save(washRequestItem);

	}

}
