package com.zildo.dto;

import lombok.Data;

@Data
public class UsuarioSaidaDTO {

    private String nomeUsuario;

    private Integer idade;

    private String cidade;

    private String bairro;

    private String estado;

    private String documento;

    public void getIdade(Integer idade) {
        this.idade = idade;
    }
}
