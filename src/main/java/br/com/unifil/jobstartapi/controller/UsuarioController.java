package br.com.unifil.jobstartapi.controller;

import br.com.unifil.jobstartapi.dto.UsuarioRequest;
import br.com.unifil.jobstartapi.dto.UsuarioResponse;
import br.com.unifil.jobstartapi.service.UsuarioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
@Api(tags = "Usuario Controller")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponse validarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return usuarioService.validarUsuario(usuarioRequest);
    }
}
