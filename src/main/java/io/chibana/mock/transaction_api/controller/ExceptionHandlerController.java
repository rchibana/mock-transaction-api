package io.chibana.mock.transaction_api.controller;

import io.chibana.mock.transaction_api.dto.ApiResponseError;
import io.chibana.mock.transaction_api.dto.ErrorField;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Log4j2
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Object> handlerBadRequest(ConstraintViolationException ex) {
        log.error("ERROR, message={}", ex.getMessage());
        List<ErrorField> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(new ErrorField(violation.getRootBeanClass().getName(), violation.getMessage()));
        }
        final ApiResponseError apiErrorResponse = new ApiResponseError(HttpStatus.BAD_REQUEST);
        apiErrorResponse.setTitle("One or more fields are invalid");
        apiErrorResponse.setTimestamp(OffsetDateTime.now());
        apiErrorResponse.setErrorFields(errors);

        return buildResponseEntity(apiErrorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiResponseError apiErrorResponse) {
        return new ResponseEntity<>(apiErrorResponse, apiErrorResponse.getStatusCode());
    }
}
