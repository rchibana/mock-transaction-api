package io.chibana.mock.transaction_api.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Transaction {

    private String description;
    private Integer value;
    private Timestamp creationDate;

}
