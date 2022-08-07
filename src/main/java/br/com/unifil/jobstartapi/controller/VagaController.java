package br.com.unifil.jobstartapi.controller;

import br.com.unifil.jobstartapi.dto.VagaRequest;
import br.com.unifil.jobstartapi.dto.VagaResponse;
import br.com.unifil.jobstartapi.model.Vaga;
import br.com.unifil.jobstartapi.service.VagaService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/vagas")
@Api(tags = "Vaga Controller")
public class VagaController {

    private VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @GetMapping
    public List<VagaResponse> listarVagas() {
        return vagaService.listarVagas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VagaResponse criarVaga(@RequestBody @Valid VagaRequest vagaRequest) {
        return vagaService.criarVaga(Vaga.of(vagaRequest));
    }

    @DeleteMapping("{id}")
    public void excluirVaga(@PathVariable Long id) {
        vagaService.excluirVaga(id);
    }
}
