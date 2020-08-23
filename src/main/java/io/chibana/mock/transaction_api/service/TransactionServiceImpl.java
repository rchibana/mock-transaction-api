package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.repository.TransactionRepository;
import io.chibana.mock.transaction_api.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public Transaction getOrCreateUsersTransactionsByYearAndMonth(final Integer userId, final String year, final String month) {
        final Timestamp createdDate = getTimestampByMonthAndYear(year, month);
        return this.getUsersTransactionsByTimestamp(userId, createdDate)
                .orElseGet(() -> this.createUsersTransactionWithTimestamp(userId, createdDate));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction> getUsersTransactionsByTimestamp(Integer userId, Timestamp createdDate) {
        return transactionRepository.findByUserIdAndCreatedDate(userId, createdDate);
    }

    @Override
    public Transaction createUsersTransactionWithTimestamp(Integer userId, Timestamp createdDate) {
        Transaction transaction = new Transaction(userId, createdDate);
        transactionRepository.save(transaction);
        return transaction;
    }

    private Timestamp getTimestampByMonthAndYear(String year, String month) {
        final String date = String.format("%s-%s-01T00:00:00Z", year, month);
        final Instant instantParsed = Instant.parse(date);
        return Timestamp.from(instantParsed);
    }
}
