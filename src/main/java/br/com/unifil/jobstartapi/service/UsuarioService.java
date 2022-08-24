package br.com.unifil.jobstartapi.service;

import br.com.unifil.jobstartapi.dto.EmpresaRequest;
import br.com.unifil.jobstartapi.dto.UsuarioRequest;
import br.com.unifil.jobstartapi.dto.UsuarioResponse;
import br.com.unifil.jobstartapi.exception.ValidacaoException;
import br.com.unifil.jobstartapi.model.Empresa;
import br.com.unifil.jobstartapi.model.Usuario;
import br.com.unifil.jobstartapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criarUsuario(Empresa empresa, EmpresaRequest empresaRequest) {
        var usuario = Usuario.of(empresa, empresaRequest);
        usuarioRepository.save(usuario);
    }

    public UsuarioResponse validarUsuario(UsuarioRequest usuarioRequest) {
        var usuario = obterUsuarioPorLogin(usuarioRequest.getLogin());
        if (!usuario.getSenha().equals(usuarioRequest.getSenha())) {
            throw new ValidacaoException("Senha inválida.");
        }
        return UsuarioResponse.of(usuario);
    }

    private Usuario obterUsuarioPorLogin(String login) {
        return usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new ValidacaoException("Usuário não encontrado."));
    }
}
