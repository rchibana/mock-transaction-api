package io.chibana.mock.transaction_api.controller;

import io.chibana.mock.transaction_api.dto.TransactionRequestDTO;
import io.chibana.mock.transaction_api.dto.TransactionResponseDTO;
import io.chibana.mock.transaction_api.dto.mapper.TransactionMapper;
import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.service.TransactionService;
import io.chibana.mock.transaction_api.validator.Month;
import io.chibana.mock.transaction_api.validator.UserId;
import io.chibana.mock.transaction_api.validator.Year;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/{userId}/transacoes")
@AllArgsConstructor
@Validated
public class UsersTransactionsController {

    private TransactionService transactionService;
    private TransactionMapper transactionMapper;

    @GetMapping("/{year}/{month}")
    public TransactionResponseDTO getUsersTransactionsByYearAndMonth(
            @PathVariable("userId") @UserId Integer userId,
            @PathVariable("year") @Year Integer year,
            @PathVariable("month") @Month Integer month) {

        final TransactionRequestDTO transactionRequestDTO = new TransactionRequestDTO(userId, year, month);
        Transaction transaction = this.transactionMapper.requestDTOToModel(transactionRequestDTO);

        final Transaction transactionResult = this.transactionService.getOrCreateTransactionByTimestamp(transaction);

        return this.transactionMapper.modelToResponseDTO(transactionResult);
    }

}
