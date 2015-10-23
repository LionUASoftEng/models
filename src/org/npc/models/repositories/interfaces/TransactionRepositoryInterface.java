package org.npc.models.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.models.Transaction;
import java.util.UUID;

public interface TransactionRepositoryInterface extends BaseRepositoryInterface<Transaction>{
	Transaction byTransactionId(UUID transactionId);
}
