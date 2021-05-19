package com.zildo.controller;

import com.zildo.dto.UsuarioEntradaDTO;
import com.zildo.dto.UsuarioSaidaDTO;
import com.zildo.model.Usuario;
import com.zildo.repository.UsuarioRepository;
import com.zildo.service.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioServiceImpl usuarioService;

    @PostMapping("/salvar")
    public Usuario salvarUsuario(@RequestBody UsuarioEntradaDTO usuario){
        return usuarioRepository.save(usuarioService.salvarUsuario(usuario));
    };

    @GetMapping("/{documento}")
    public UsuarioSaidaDTO obterPorDocumento(@PathVariable String documento){
        return usuarioService.findByDocumento(documento);
    };
}
