package airsponge.com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import airsponge.com.au.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByName(String rolename);
	
}
