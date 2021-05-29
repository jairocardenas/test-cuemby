package com.cuemby.demo.main.exceptions.handling;


import com.cuemby.demo.core.exceptions.CustomException;
import com.cuemby.demo.core.exceptions.ResourceAlreadyExists;
import com.cuemby.demo.core.exceptions.ResourceNotFoundException;
import com.cuemby.demo.main.exceptions.custom.UnauthorizedException;
import com.cuemby.demo.main.resources.responses.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        String message = "Ha ocurrido un error";
        log.error(ex.getMessage());

        return new ResponseEntity<>(
                new ExceptionResponse("INTERNAL_SERVER_ERROR", message),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            details.add("El campo " + error.getField() + " " + error.getDefaultMessage());
        }

        return new ResponseEntity<>(
                new ExceptionResponse("BAD_REQUEST", details),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> notReadableException(HttpMessageNotReadableException ex) {
        String message = "Request mal formada";
        return new ResponseEntity<>(
                new ExceptionResponse("BAD_REQUEST", message),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                new ExceptionResponse("NOT_FOUND", ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceAlreadyExists ex) {
        return new ResponseEntity<>(
                new ExceptionResponse("CONFLICT", ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customException(CustomException ex) {
        return new ResponseEntity<>(
                new ExceptionResponse("BAD_REQUEST", ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedException ex) {
        return new ResponseEntity<>(
                new ExceptionResponse("UNAUTHORIZED", ex.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }

}
