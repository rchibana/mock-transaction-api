package io.chibana.mock.transaction_api.controller;

import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{userId}/transacoes")
@AllArgsConstructor
public class UsersTransactionsController {

    private TransactionService transactionService;

    @GetMapping("/{year}/{month}")
    public List<Transaction> getUsersTransactionsByYearAndMonth(
            @PathVariable("userId") int userId,
            @PathVariable("year") int year,
            @PathVariable("month") int month) {


        final List<Transaction> usersTransactions =
                this.transactionService.getOrCreateUsersTransactionsByYearAndMonth(userId, year, month);

        return usersTransactions;
    }



}
