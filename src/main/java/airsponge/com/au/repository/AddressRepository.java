package airsponge.com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import airsponge.com.au.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
