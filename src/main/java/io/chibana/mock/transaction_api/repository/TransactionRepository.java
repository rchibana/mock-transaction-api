package io.chibana.mock.transaction_api.repository;

import io.chibana.mock.transaction_api.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    Optional<Transaction> findByUserIdAndCreatedDate(Integer userId, Timestamp createdDate);

}
