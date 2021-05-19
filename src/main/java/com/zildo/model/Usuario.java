package com.zildo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
public class Usuario {

    @Id
    private String id;

    private String nomeUsuario;

    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private Date dataDeNascimento;

    private String cidade;

    private String bairro;

    private String estado;

    private String documento;
}
