package com.example.demo.exception;

import javassist.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler({ RepositoryConstraintViolationException.class })
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        RepositoryConstraintViolationException nevEx = (RepositoryConstraintViolationException) ex;

        String errors = nevEx
                .getErrors()
                .getAllErrors()
                .stream()
                .map(ObjectError::toString)
                .collect(Collectors.joining("\n"));
        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    public ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest request) {
        logger.error("not found");

        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);

    }


}
