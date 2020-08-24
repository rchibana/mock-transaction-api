package io.chibana.mock.transaction_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponseError {

    private HttpStatus statusCode;
    private String errorMessage;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    public ApiResponseError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponseError(HttpStatus statusCode) {
        this();
        this.statusCode = statusCode;
    }


}

