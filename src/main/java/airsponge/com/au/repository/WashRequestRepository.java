
package airsponge.com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import airsponge.com.au.entity.WashRequest;
import airsponge.com.au.entity.Washee;
import airsponge.com.au.entity.Washer;

public interface WashRequestRepository extends JpaRepository<WashRequest, Integer> {

	public List<WashRequest> findByWashee(Washee washee);
}
