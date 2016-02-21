package org.adria.virementMultiple.dao;

import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepo extends JpaRepository<Transfer, Integer>{
	
	
	List<MultipleTransfers> getByAccountIn(List<Account> account);
	

}
