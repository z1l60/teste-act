package com.zildo.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {

    private String message;

    private Date data;

    public ErrorMessage(String message, Date data){
        this.message = message;
        this.data = data;
    }
}
