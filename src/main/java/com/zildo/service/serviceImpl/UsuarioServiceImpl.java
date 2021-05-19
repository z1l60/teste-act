package com.zildo.service.serviceImpl;

import com.zildo.controller.ViaCepController;
import com.zildo.dto.EnderecoDTO;
import com.zildo.dto.UsuarioEntradaDTO;
import com.zildo.dto.UsuarioSaidaDTO;
import com.zildo.model.Usuario;
import com.zildo.repository.UsuarioRepository;
import com.zildo.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ViaCepController viaCepController;

    @Override
    public Usuario salvarUsuario(UsuarioEntradaDTO usuario) {
        Usuario resposta = new Usuario();
        resposta.setNomeUsuario(usuario.getNomeUsuario());
        resposta.setDataDeNascimento(usuario.getDataDeNascimento());
        resposta.setDocumento(usuario.getDocumento());
        ResponseEntity<EnderecoDTO> req = (viaCepController.buscarEndereco(usuario.getCep()));
        EnderecoDTO endereco = req.getBody();
        resposta.setBairro(endereco.getBairro());
        resposta.setCidade(endereco.getLocalidade());
        resposta.setEstado(endereco.getUf());
        return resposta;
    }

    @Override
    public UsuarioSaidaDTO findByDocumento(String documento) {
        Usuario usuario = usuarioRepository.findByDocumento(documento);
        Integer idade = calculaIdade(usuario);
        UsuarioSaidaDTO resposta = new UsuarioSaidaDTO();
        resposta.setNomeUsuario(usuario.getNomeUsuario());
        resposta.setIdade(idade);
        resposta.setCidade(usuario.getCidade());
        resposta.setBairro(usuario.getBairro());
        resposta.setEstado(usuario.getEstado());
        resposta.setDocumento(usuario.getDocumento());
        return resposta;
    }

    @Override
    public Integer calculaIdade(Usuario usuario) {
        Date dataAtual = new Date();
        Date nascimento = usuario.getDataDeNascimento();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Integer ano1 = Integer.parseInt(sdf.format(nascimento));
        Integer ano2 = Integer.parseInt(sdf.format(dataAtual));
        Integer idade = (ano2 - ano1) - 1;
        return idade;
    }
}
