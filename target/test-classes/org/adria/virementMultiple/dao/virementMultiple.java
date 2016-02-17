package org.adria.virementMultiple.dao;

import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")

@TransactionConfiguration(defaultRollback=false)
@Transactional
public class virementMultiple {

	
	
	
	@Autowired 
	IBanqueDao banqueDao;
	
	@Autowired
	private IBanqueDao banqueService;
	
	@Test
	public void findByUsernameTest(){
		System.out.println(banqueDao.findByUsername("jira").getFirstName());
	
	}
	
	@Test
	public void findBeneficiary(){
		
		Subscriber s=new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		s.setId(new Long(1));
		System.out.println(banqueDao.getAccountBySubscriber(s).size());
	}
	
	@Test
	public void findBeneficiaries(){
		Subscriber s=new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		s.setId(new Long(1));
		System.out.println(banqueDao.getBeneficiaries(s).size());
	}
	
	@Test
	public void findBeneficiaryById(){
		Beneficiary b=banqueDao.getBeneficiaryById(new Long(1));
		System.out.println(b.getFirstName());
	}
	
	@Test
	public void getAccountBySubscriberIdServiceTest(){
		System.out.println("getAccountBySubscriberIdServiceTest --> "+banqueService.getAccountBySubscriberId(new Long(1)));
	}
	
	@Test
	public void getAccountBySubscriberIdSubscriberTest(){
		Subscriber subscriber =new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		subscriber.setId(new Long(1));
		System.out.println("getAccountBySubscriberIdSubscriberTest --> "+banqueService.getAccountBySubscriber(subscriber));
	}

}
