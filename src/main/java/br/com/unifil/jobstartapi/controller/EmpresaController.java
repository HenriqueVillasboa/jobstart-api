package br.com.unifil.jobstartapi.controller;

import br.com.unifil.jobstartapi.dto.EmpresaRequest;
import br.com.unifil.jobstartapi.dto.EmpresaResponse;
import br.com.unifil.jobstartapi.model.Empresa;
import br.com.unifil.jobstartapi.service.EmpresaService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/empresas")
@Api(tags = "Empresa Controller")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<EmpresaResponse> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaResponse criarEmpresa(@RequestBody @Valid EmpresaRequest empresaRequest) {
        return empresaService.criarEmpresa(Empresa.of(empresaRequest));
    }
}
