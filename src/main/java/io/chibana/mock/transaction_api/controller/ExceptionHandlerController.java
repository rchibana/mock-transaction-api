package io.chibana.mock.transaction_api.controller;

import io.chibana.mock.transaction_api.dto.ApiResponseError;
import io.chibana.mock.transaction_api.dto.ErrorField;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Log4j2
@AllArgsConstructor
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ErrorField> errorFields = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            errorFields.add(new ErrorField(fieldName, message));
        }

        final ApiResponseError error = new ApiResponseError();
        error.setStatusCode(HttpStatus.valueOf(status.value()));
        error.setTitle("One or more fields are invalid");
        error.setTimestamp(OffsetDateTime.now());
        error.setErrorFields(errorFields);

        return super.handleExceptionInternal(ex, error, headers, status, request);
    }

}
