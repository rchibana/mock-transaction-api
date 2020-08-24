package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;

import java.sql.Timestamp;
import java.util.Optional;

public interface TransactionService {

    Transaction getOrCreateTransactionByTimestamp(Transaction transaction);

    Optional<Transaction> getUsersTransactionsByTimestamp(Integer userId, Timestamp createdDate);

    Transaction createUsersTransaction(Transaction transaction);

}
