package org.adria.virementMultiple.dao;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MutipleTransferRepo  extends JpaRepository<MultipleTransfers, Long>,JpaSpecificationExecutor<MultipleTransfers>{
	
	
	
	
	

}
