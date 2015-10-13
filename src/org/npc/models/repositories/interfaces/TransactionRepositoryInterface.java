package org.npc.models.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.models.Transaction;

public interface TransactionRepositoryInterface extends BaseRepositoryInterface<Transaction>{
	Transaction byTransactionId(int transactionId);
}
