package io.chibana.mock.transaction_api.model;

import io.chibana.mock.transaction_api.util.Utils;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public final class Transaction {

    public Transaction(Integer userId, Timestamp createdDate) {
        this.userId = userId;
        this.createdDate = createdDate;
        this.description = Utils.generateRandomString(120, 10);
        this.value = Utils.generateRandomBigInteger(7, 1);
    }

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @DecimalMin(value = "1000")
    @DecimalMax(value = "100000000")
    private Integer userId;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 120)
    private String description;

    @NotNull
    @DecimalMin(value = "-999999999")
    @DecimalMax(value = "999999999")
    private BigInteger value;

    @NotNull
    private Timestamp createdDate;

}
