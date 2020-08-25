package io.chibana.mock.transaction_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class ApiResponseError {

    private HttpStatus statusCode;
    private String title;
    private List<ErrorField> errorFields;
    private OffsetDateTime timestamp;

    public ApiResponseError() {
        this.timestamp = OffsetDateTime.now();
    }

    public ApiResponseError(HttpStatus statusCode) {
        this();
        this.statusCode = statusCode;
    }


}

