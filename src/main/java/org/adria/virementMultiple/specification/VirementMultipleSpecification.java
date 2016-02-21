package org.adria.virementMultiple.specification;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.adria.virementMultiple.dto.MultipleTransferSearchDTO;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.util.Functions;
import org.springframework.data.jpa.domain.Specification;

public final class VirementMultipleSpecification 
{
	public static Specification<MultipleTransfers> virementMultipleList(final Long id ,final MultipleTransferSearchDTO vMS) {
		return new Specification<MultipleTransfers>() {

			public Predicate toPredicate(Root<MultipleTransfers> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				if (vMS.getAccountNumber() != null &&  !vMS.getAccountNumber().equals("") ) {
					predicates.add(cb.equal(root.get("account").get("accountNumber"),vMS.getAccountNumber()));
				}
				if (vMS.getMaxBalancing() != null && !vMS.getMaxBalancing().equals("")) {
					predicates.add(cb.lessThanOrEqualTo(root.<BigInteger>get("balance"),vMS.getMaxBalancing()));
				} if (vMS.getMinBalancing() != null && !vMS.getMinBalancing().equals("")) {
					predicates.add(cb.greaterThanOrEqualTo(root.<BigInteger>get("balance"),vMS.getMinBalancing()));
				}
				if (!predicates.isEmpty()) {
					return cb.and(predicates.toArray(new Predicate[predicates
							.size()]));
				}

				return null;
			}

		};
	}
}
