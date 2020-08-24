package io.chibana.mock.transaction_api.service;

import io.chibana.mock.transaction_api.model.Transaction;
import io.chibana.mock.transaction_api.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TransactionServiceImplTest {

    private static final Integer USER_ID = 1111;
    private static final Timestamp CREATED_DATE = Timestamp.from(Instant.now());

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private Transaction transaction;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.transaction = new Transaction(USER_ID, CREATED_DATE);
        this.transaction.setId(1L);
    }

    @Test
    public void testGetUsersTransactionsByTimestamp() {
        when(this.transactionRepository.findByUserIdAndCreatedDate(USER_ID, CREATED_DATE))
                .thenReturn(Optional.of(this.transaction));

        Optional<Transaction> response = this.transactionService.getUsersTransactionsByTimestamp(this.transaction);

        assertTrue(response.isPresent());
        assertEquals(response.get(), this.transaction);
    }

    @Test
    public void testGetUsersTransactionsByTimestampDoesNotExist() {
        when(this.transactionRepository.findByUserIdAndCreatedDate(USER_ID, CREATED_DATE))
                .thenReturn(Optional.empty());

        Optional<Transaction> response = this.transactionService.getUsersTransactionsByTimestamp(this.transaction);

        assertFalse(response.isPresent());
    }

    @Test
    public void testCreateUsersTransaction() {
        when(this.transactionRepository.save(this.transaction))
                .thenReturn(this.transaction);

        Transaction response = this.transactionService.createUsersTransaction(this.transaction);

        assertEquals(response, this.transaction);
    }

    @Test
    public void testCreateUsersTransactionMissingValue() {
        Transaction mockTransaction = new Transaction();
        when(this.transactionRepository.save(mockTransaction))
                .thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> {
            this.transactionService.createUsersTransaction(mockTransaction);
        });
    }

    @Test
    public void testGetOrCreateTransactionByTimestampShouldReturnExistent() {
        when(this.transactionService.getUsersTransactionsByTimestamp(this.transaction))
                .thenReturn(Optional.of(this.transaction));

        Transaction response = this.transactionService.getOrCreateTransactionByTimestamp(this.transaction);

        assertEquals(response, this.transaction);
    }

    @Test
    public void testGetOrCreateTransactionByTimestampShouldCreateWhenNotExist() {
        when(this.transactionService.getUsersTransactionsByTimestamp(this.transaction))
                .thenReturn(Optional.empty());
        when(this.transactionService.createUsersTransaction(this.transaction))
                .thenReturn(this.transaction);

        Transaction response = this.transactionService.getOrCreateTransactionByTimestamp(this.transaction);

        assertEquals(response, this.transaction);
    }

}
