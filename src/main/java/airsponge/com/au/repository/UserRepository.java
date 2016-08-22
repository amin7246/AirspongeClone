package airsponge.com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import airsponge.com.au.entity.Role;
import airsponge.com.au.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	
	public User findByEmail(String email);
}
