package org.adria.virementMultiple.dao;


import java.util.List;

import org.adria.virementMultiple.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer>{

	
	public Subscriber findByUsername(String username);
	
	public List<Subscriber> findAll();
	
 
}

