package io.chibana.mock.transaction_api.dto;

import lombok.Data;
import lombok.Builder;

import java.sql.Timestamp;

@Data
public class TransactionResponseDTO {

    private Integer userId;
    private Timestamp createdDate;
    private String value;
    private String description;

}
