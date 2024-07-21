package fr.it4innov.myasso.association.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler /*extends ResponseEntityExceptionHandler TODO à regarder*/ {

    private String messageToSend="";

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResponseError> handleResponseStatusException(ResponseStatusException ex) {
        ResponseError responseError = ResponseError.builder()
                .httpStatus(NOT_FOUND)
                .message(ex.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
        return getResponseError(responseError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError>  handleResponseException(Exception ex) {
        ResponseError responseError = ResponseError.builder()
                .httpStatus(NOT_ACCEPTABLE)
                .message(ex.getMessage())
                .errorTime(LocalDateTime.now())
                .build();

        if (ex instanceof NumberFormatException) {
            responseError.setMessage(ex.getMessage());
        } else if (ex instanceof NoResourceFoundException) {
            responseError.setHttpStatus(NOT_FOUND);
            responseError.setMessage(ex.getMessage());
        } else if (ex instanceof InvalidMediaTypeException) {
            responseError.setHttpStatus(UNSUPPORTED_MEDIA_TYPE);
        } else if (ex instanceof SecurityException) {
            responseError.setHttpStatus(FORBIDDEN);
        } else if (ex instanceof ConstraintViolationException) {
            responseError.setHttpStatus(CONFLICT);
            ((ConstraintViolationException) ex).getConstraintViolations().forEach(constraintViolation -> {
                messageToSend=messageToSend+constraintViolation.getMessageTemplate()+";";
            }) ;
            responseError.setMessage(messageToSend);
        } else {
            responseError.setHttpStatus(BAD_REQUEST);
        }
        return getResponseError(responseError);
    }

    private ResponseEntity<ResponseError> getResponseError(ResponseError responseError) {
        return new ResponseEntity<>(responseError, responseError.getHttpStatus());
    }
}
