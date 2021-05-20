package com.zildo.exceptions;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value= {HttpClientErrorException.class})
    public ResponseEntity<Object> handleCepException(Exception e, WebRequest request) {
        String errorDescription = "Cep inválido, favor informar um cep válido";
        if(errorDescription == null) errorDescription = e.toString();
        ErrorMessage errorMessage = new ErrorMessage(errorDescription, new Date());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value= {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception e, WebRequest request) {
        String errorDescription = "Documento inexistente em nosso cadastro, favor tentar novamente";
        if(errorDescription == null) errorDescription = e.toString();
        ErrorMessage errorMessage = new ErrorMessage(errorDescription, new Date());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value= {IncorrectResultSizeDataAccessException.class})
    public ResponseEntity<Object> handleDoubleRegisterException(Exception e, WebRequest request) {
        String errorDescription = "Existe mais de um usuário cadastrado com o mesmo documento informado, favor entrar em contato com nosso suporte.";
        if(errorDescription == null) errorDescription = e.toString();
        ErrorMessage errorMessage = new ErrorMessage(errorDescription, new Date());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
