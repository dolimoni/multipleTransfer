package org.adria.virementMultiple.service;

import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.adria.virementMultiple.entities.Subscriber;

public interface IBanqueService {
	
	Boolean authenticate(String username,String password);
	List<Beneficiary> getBeneficiaries(Subscriber subscriber);
	Beneficiary getBeneficiaryById(Long id);
	List<Account> getAccountBySubscriber(Subscriber subscriber);
	List<Account> getAccountBySubscriberId(Long id);
	Boolean Save(List<MultipleTransfersBeneficiary> mtb);
	Boolean Confirme(String username,String password);

}
