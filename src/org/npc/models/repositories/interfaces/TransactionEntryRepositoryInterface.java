package org.npc.models.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.models.TransactionEntry;
import java.util.UUID;

public interface TransactionEntryRepositoryInterface extends BaseRepositoryInterface<TransactionEntry>{
	TransactionEntry byRecordId(UUID recordId);
	TransactionEntry byTransactionId(UUID transactionId);
	TransactionEntry byProductId(UUID productId);
}