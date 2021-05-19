package com.zildo.service;

import com.zildo.dto.EnderecoDTO;
import com.zildo.dto.UsuarioEntradaDTO;
import com.zildo.dto.UsuarioSaidaDTO;
import com.zildo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

public interface UsuarioService {

    public Usuario salvarUsuario(UsuarioEntradaDTO usuario);

    public UsuarioSaidaDTO findByDocumento(String documento);

    public Integer calculaIdade(Usuario usuario);
}
