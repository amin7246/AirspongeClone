package airsponge.com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import airsponge.com.au.entity.User;
import airsponge.com.au.entity.Washer;

public interface WasherRepository extends JpaRepository<Washer, Integer> {
	public Washer findByUser(User user); 
}
