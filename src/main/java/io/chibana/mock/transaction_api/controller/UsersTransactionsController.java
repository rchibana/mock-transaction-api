package io.chibana.mock.transaction_api.controller;

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

    @GetMapping("/{year}/{month}")
    public Transaction getUsersTransactionsByYearAndMonth(
            @PathVariable("userId") int userId,
            @PathVariable("year") String year,
            @PathVariable("month") String month) {

        final Transaction transaction =
                this.transactionService.getOrCreateUsersTransactionsByYearAndMonth(userId, year, month);

        return transaction;
    }

}
