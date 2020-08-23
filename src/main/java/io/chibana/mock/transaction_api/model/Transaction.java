package io.chibana.mock.transaction_api.model;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Random;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @DecimalMin(value = "1000")
    @DecimalMax(value = "100000000")
    private Integer userId;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @DecimalMin(value = "-999999999")
    @DecimalMax(value = "999999999")
    private BigInteger value;

    @NotNull
    private Timestamp creationDate;

}
