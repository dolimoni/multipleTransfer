package org.adria.virementMultiple.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.adria.virementMultiple.dto.MultipleTransferSearchDTO;
import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.entities.Subscriber;
import org.adria.virementMultiple.specification.VirementMultipleSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
public class Search {

	@Autowired 
	IBanqueDao banqueDao;
	
	@Autowired
	private IBanqueDao banqueService;
	
	@Autowired
	private AccountRepo ar;
	
	private static final Logger logger = LoggerFactory.getLogger(virementMultiple.class);
	 @Test
	 public void TransfersByAccounts()
	 {
		 MultipleTransferSearchDTO multipleTransferSearchDTO = null;
		 
		 Specification<MultipleTransfers> specification =VirementMultipleSpecification.virementMultipleList(new Long(1), multipleTransferSearchDTO);
			
	 }
}
