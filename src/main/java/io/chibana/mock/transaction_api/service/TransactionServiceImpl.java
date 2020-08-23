package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private UserRepository userRepository;

    @Override
    public List<Transaction> getUsersTransactionsByYearAndMonth(Integer userId, Integer year, Integer month) {
        return null;
    }
}
