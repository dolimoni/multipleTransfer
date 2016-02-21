package org.adria.virementMultiple.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.adria.virementMultiple.entities.Account;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification implements Specification<Account>{

	 private Account filter;
	 
	 public AccountSpecification(Account filter) {
	        super();
	        this.filter = filter;
	    }
	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> arg1, CriteriaBuilder cb) {
		Predicate p = cb.disjunction();
		if (filter.getAccountNumber()!= null) {
            p.getExpressions()
                    .add(cb.equal(root.get("accountNumber"), filter.getAccountNumber()));
        }

        if (filter.getBalancing() != null && filter.getEntitled() != null) {
            p.getExpressions().add(
                    cb.and(cb.equal(root.get("balancing"), filter.getBalancing()),
                            cb.equal(root.get("entitled"), filter.getEntitled())));
        }

        return p;
		
		
	}

}
