package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public Transaction getOrCreateTransactionByTimestamp(final Transaction transaction) {
        return this.getUsersTransactionsByTimestamp(transaction.getUserId(), transaction.getCreatedDate())
                .orElseGet(() -> this.createUsersTransaction(transaction));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction> getUsersTransactionsByTimestamp(final Integer userId, final Timestamp createdDate) {
        return transactionRepository.findByUserIdAndCreatedDate(userId, createdDate);
    }

    @Override
    public Transaction createUsersTransaction(final Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
