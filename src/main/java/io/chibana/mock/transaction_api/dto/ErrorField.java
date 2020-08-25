package io.chibana.mock.transaction_api.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorField {

    private String name;
    private String message;

}