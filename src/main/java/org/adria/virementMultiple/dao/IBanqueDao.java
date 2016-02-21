package org.adria.virementMultiple.dao;

import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.adria.virementMultiple.entities.Transfer;

public interface IBanqueDao {

	Boolean authenticate(String username,String password);
	List<Beneficiary> getBeneficiaries(Subscriber subscriber);
	Beneficiary getBeneficiaryById(Long id);
	List<Account> getAccountBySubscriber(Subscriber subscriber);
	List<Account> getAccountBySubscriberId(Long id);
	Boolean Save(List<MultipleTransfersBeneficiary> mtb);
	Boolean Confirme(String username,String password);
	Subscriber findByUsername(String username);	
	MultipleTransfers save(MultipleTransfers multipleTransfers);
	MultipleTransfers getMultipleTransfers(MultipleTransfers multipleTransfers);
	MultipleTransfers getTransfer(Long id);
	List<MultipleTransfers> getTransfersByAccount(List<Account> accounts);
	
	
	Transfer addTransfer(Transfer transfer);
	MultipleTransfersBeneficiary addMultipleTranfersBeneficiary(MultipleTransfersBeneficiary multipleTransfersBeneficiary);
}
