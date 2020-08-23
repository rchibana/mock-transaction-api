package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public final class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getOrCreateUsersTransactionsByYearAndMonth(Integer userId, Integer year, Integer month) {
        return null;
    }

    @Override
    public Transaction createTransaction(Integer userId) {
        return null;
    }
}
