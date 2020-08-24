package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public Transaction getOrCreateTransactionByTimestamp(final Transaction transaction) {
        return this.getUsersTransactionsByTimestamp(transaction)
                .orElseGet(() -> this.createUsersTransaction(transaction));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction> getUsersTransactionsByTimestamp(Transaction transaction) {
        return transactionRepository.findByUserIdAndCreatedDate(transaction.getUserId(), transaction.getCreatedDate());
    }

    @Override
    public Transaction createUsersTransaction(final Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
