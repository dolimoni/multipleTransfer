package org.adria.virementMultiple.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.adria.virementMultiple.entities.Transfer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	
	
	private static final Logger logger = LoggerFactory.getLogger(virementMultiple.class);
	@Autowired 
	IBanqueDao banqueDao;
	
	@Autowired
	private IBanqueDao banqueService;
	
	@Autowired
	private AccountRepo ar;
	
	@Test
	public void findByUsernameTest(){
		
		logger.info("findByUsernameTest() --> ", banqueDao.findByUsername("jira").getFirstName());
	}
	
	@Test
	public void findBeneficiary(){
		
		Subscriber s=new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		s.setId(new Long(1));
		logger.info("findBeneficiary() --> ", banqueDao.getAccountBySubscriber(s).size());
		
	}
	
	@Test
	public void findBeneficiaries(){
		Subscriber s=new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		s.setId(new Long(1));
		
		logger.info("findBeneficiaries() --> ",banqueDao.getBeneficiaries(s).size());
	}
	
	@Test
	public void findBeneficiaryById(){
		Beneficiary b=banqueDao.getBeneficiaryById(new Long(1));
		logger.info("findBeneficiaries() --> ",b.getFirstName());
	}
	
	@Test
	public void getAccountBySubscriberIdServiceTest(){
		
		logger.info("getAccountBySubscriberIdServiceTest() --> "+banqueService.getAccountBySubscriberId(new Long(1)));
	}
	
	@Test
	public void getAccountBySubscriberIdSubscriberTest(){
		Subscriber subscriber =new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		subscriber.setId(new Long(1));
		
		logger.info("getAccountBySubscriberIdSubscriberTest() --> "+banqueService.getAccountBySubscriber(subscriber));
	}
	
	 @Test
	 public void accountSpecificationTest(){
		
		 Account account =new Account("compte atlas n 1",new BigInteger("150000"));
		 account.setAccountNumber(new Long(1));
		 AccountSpecification as=new AccountSpecification(account);
		 
		
	 }

	 @Test
	 public void saveMultipleTransfersTest(){
		
		
		
		Account account=banqueDao.getAccountBySubscriberId(new Long(1)).get(0);
		
		MultipleTransfers multipleTransfers = new MultipleTransfers(new Date(), new Date(), new BigInteger("1300"), "test2", 2, "saved");
		
		multipleTransfers.setAccount(account);
		MultipleTransfers multipleTransfers2=banqueDao.save(multipleTransfers);
		
		Beneficiary beneficiary1=banqueDao.getBeneficiaryById(new Long(1));
		Beneficiary beneficiary2=banqueDao.getBeneficiaryById(new Long(3));
		MultipleTransfersBeneficiary multipleTransfersBeneficiary=new MultipleTransfersBeneficiary(multipleTransfers2, beneficiary1,new Long(500));
		MultipleTransfersBeneficiary multipleTransfersBeneficiary2=new MultipleTransfersBeneficiary(multipleTransfers2, beneficiary2, new Long(800));
		
		banqueDao.addMultipleTranfersBeneficiary(multipleTransfersBeneficiary);
		banqueDao.addMultipleTranfersBeneficiary(multipleTransfersBeneficiary2);
		
		
		logger.info("---------> saveMultipleTransfersTest()"+" ---------> ");
		 
		
	 }
	 
	 
	 @Test
	 public void saveTransferTest(){
		 
		 Account account=banqueDao.getAccountBySubscriberId(new Long(1)).get(0);
		 
		 Transfer transfer = new Transfer(new Date(), new Date(), new BigInteger("20"),"test");
		 transfer.setAccount(account);
		 
		 
		 logger.info("saveTransferTest --> "+banqueDao.addTransfer(transfer));
	 }
	 
	

}
