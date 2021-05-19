package com.zildo.repository;

import com.zildo.dto.UsuarioSaidaDTO;
import com.zildo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByDocumento(String documento);
}
