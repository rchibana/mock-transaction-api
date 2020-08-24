package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;

import java.util.Optional;

public interface TransactionService {

    Transaction getOrCreateTransactionByTimestamp(Transaction transaction);

    Optional<Transaction> getUsersTransactionsByTimestamp(Transaction transaction);

    Transaction createUsersTransaction(Transaction transaction);

}
