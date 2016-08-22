package airsponge.com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import airsponge.com.au.entity.User;
import airsponge.com.au.entity.Washee;

public interface WasheeRepository extends JpaRepository<Washee, Integer>{

	public Washee findByUser(User user);

}
