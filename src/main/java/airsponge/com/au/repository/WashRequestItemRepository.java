package airsponge.com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import airsponge.com.au.entity.WashRequest;
import airsponge.com.au.entity.WashRequestItem;
import airsponge.com.au.entity.Washer;

public interface WashRequestItemRepository extends JpaRepository<WashRequestItem, Integer>{

	public List<WashRequestItem> findByWashRequest(WashRequest washRequest);
	public List<WashRequestItem> findByWasher(Washer washer);
	public List<WashRequestItem> findByWasherIsNull();
	
}
