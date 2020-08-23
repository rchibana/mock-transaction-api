package io.chibana.mock.transaction_api.model;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class User {

    private Integer id;
    private List<Transaction> transactions;

}
