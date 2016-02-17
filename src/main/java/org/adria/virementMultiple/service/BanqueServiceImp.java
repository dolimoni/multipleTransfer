package org.adria.virementMultiple.service;

import java.util.List;

import org.adria.virementMultiple.dao.IBanqueDao;
import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BanqueServiceImp implements IBanqueService{

	@Autowired
	private IBanqueDao banqueDao;
	
	
	@Override
	public Boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beneficiary> getBeneficiaries(Subscriber subscriber) {
		
		return banqueDao.getBeneficiaries(subscriber);
	}

	@Override
	public Beneficiary getBeneficiaryById(Long id) {
		
		return banqueDao.getBeneficiaryById(id);
	}

	@Override
	public List<Account> getAccountBySubscriber(Subscriber subscriber) {
		
		return banqueDao.getAccountBySubscriber(subscriber);
	}
	
	@Override
	public List<Account> getAccountBySubscriberId(int id) {
		
		return banqueDao.getAccountBySubscriberId(id);
	}

	@Override
	public Boolean Save(List<MultipleTransfersBeneficiary> mtb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Confirme(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	public void setBanqueDao(IBanqueDao banqueDao) {
		this.banqueDao = banqueDao;
	}


}
