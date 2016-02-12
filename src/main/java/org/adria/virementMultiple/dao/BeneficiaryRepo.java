package org.adria.virementMultiple.dao;


import java.util.List;

import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Integer>{
	
	public String findByFirstName(String name);
	
	
	
	/**
	 * get a beneficiary by id
	 * @param id
	 * @return
	 */
	
	public Beneficiary findByBeneficiaryId(Long id);
	
	
	
	/**
	 * get the list of beneficiaries of a subscriber
	 * @param subscriber
	 * @return
	 */
	public List<Beneficiary> findBySubscriber(Subscriber subscriber);

}
