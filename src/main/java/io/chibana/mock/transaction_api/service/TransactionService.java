package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getOrCreateUsersTransactionsByYearAndMonth(Integer userId, Integer year, Integer month);

    Transaction createTransaction(Integer userId);

}
