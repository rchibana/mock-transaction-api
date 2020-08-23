package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getUsersTransactionsByYearAndMonth(Integer userId, Integer year, Integer month);

}
