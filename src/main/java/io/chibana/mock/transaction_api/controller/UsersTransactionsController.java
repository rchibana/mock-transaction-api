package io.chibana.mock.transaction_api.controller;

import io.chibana.mock.transaction_api.dto.TransactionResponseDTO;
import io.chibana.mock.transaction_api.dto.mapper.TransactionMapper;
import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{userId}/transacoes")
@AllArgsConstructor
public class UsersTransactionsController {

    private TransactionService transactionService;
    private TransactionMapper transactionMapper;

    @GetMapping("/{year}/{month}")
    public TransactionResponseDTO getUsersTransactionsByYearAndMonth(
            @PathVariable("userId") int userId,
            @PathVariable("year") String year,
            @PathVariable("month") String month) {

        final Transaction transaction =
                this.transactionService.getOrCreateUsersTransactionsByYearAndMonth(userId, year, month);

        return this.transactionMapper.transactionToResponseDTO(transaction);
    }

}
