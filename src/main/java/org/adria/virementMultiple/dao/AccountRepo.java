package org.adria.virementMultiple.dao;

import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{

	
	
	
	/**
	 * get the list of accounts of a subscriber
	 * @param subscriber
	 * @return
	 */
	public List<Account> findBySubscriber(Subscriber subscriber);
	
 
}

