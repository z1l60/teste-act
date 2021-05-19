package com.zildo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class UsuarioEntradaDTO {

    private String nomeUsuario;

    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private Date dataDeNascimento;

    private String cep;

    private String documento;
}
