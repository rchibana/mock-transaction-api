package io.chibana.mock.transaction_api.controller;

import io.chibana.mock.transaction_api.dto.ApiResponseError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@Log4j2
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handlerBadRequest(Exception ex) {
        log.error("ERROR, message={}", ex.getMessage());
        final ApiResponseError apiErrorResponse = new ApiResponseError(HttpStatus.BAD_REQUEST);
        apiErrorResponse.setErrorMessage(ex.getMessage());

        return buildResponseEntity(apiErrorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiResponseError apiErrorResponse) {
        return new ResponseEntity<>(apiErrorResponse, apiErrorResponse.getStatusCode());
    }

}
