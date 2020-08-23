package io.chibana.mock.transaction_api.dto;

import lombok.Data;

@Data
public class TransactionRequestDTO {

    private Integer userId;
    private Integer month;
    private Integer year;

}
