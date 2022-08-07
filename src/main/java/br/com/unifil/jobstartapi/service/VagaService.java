package br.com.unifil.jobstartapi.service;

import br.com.unifil.jobstartapi.dto.VagaResponse;
import br.com.unifil.jobstartapi.model.Vaga;
import br.com.unifil.jobstartapi.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Transactional(readOnly = true)
    public List<VagaResponse> listarVagas() {
        return vagaRepository.findAll()
                .stream()
                .map(VagaResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public VagaResponse criarVaga(Vaga vaga) {
        var empresa = empresaService.obterEmpresaPorId(vaga.getEmpresa().getId());
        vaga.setEmpresa(empresa);
        vagaRepository.save(vaga);
        return VagaResponse.of(vaga);
    }

    @Transactional
    public void excluirVaga(Long id) {
        vagaRepository.deleteById(id);
    }
}
