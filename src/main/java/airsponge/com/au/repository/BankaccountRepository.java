package airsponge.com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import airsponge.com.au.entity.BankAccount;

public interface BankaccountRepository extends JpaRepository<BankAccount, Integer> {

}
