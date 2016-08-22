package airsponge.com.au.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsponge.com.au.entity.Role;
import airsponge.com.au.repository.RoleRepository;

@Service
public class RoleService {

//	@PersistenceContext(unitName = "remediEntities")
//	private EntityManager em;
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	 
	public List<Role> findAll(){
		
		return roleRepository.findAll();
	}


	public Role findbyid(int id) {
		return roleRepository.findOne(id);
	}

	public Role findbyname(String rolename) {
		return roleRepository.findByName(rolename);
	}

	public void save(Role role) {
		roleRepository.save(role);
		
	}


}
