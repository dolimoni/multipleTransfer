package org.adria.virementMultiple.dao;

import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleTransfersBeneficiaryRepo extends JpaRepository<MultipleTransfersBeneficiary, Integer> {

	public MultipleTransfers findByMultipleTransfer(MultipleTransfers multipleTransfers);

}
