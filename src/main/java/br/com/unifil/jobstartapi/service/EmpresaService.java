package br.com.unifil.jobstartapi.service;

import br.com.unifil.jobstartapi.dto.EmpresaRequest;
import br.com.unifil.jobstartapi.dto.EmpresaResponse;
import br.com.unifil.jobstartapi.exception.ValidacaoException;
import br.com.unifil.jobstartapi.model.Empresa;
import br.com.unifil.jobstartapi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    private static final ValidacaoException EX_EMPRESA_NAO_ENCONTRADA
            = new ValidacaoException("Empresa não encontrada.");

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional(readOnly = true)
    public List<EmpresaResponse> listarEmpresas() {
        return empresaRepository.findAll()
                .stream()
                .map(EmpresaResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public EmpresaResponse criarEmpresa(EmpresaRequest empresaRequest) {
        if (empresaRepository.existsByCnpj(empresaRequest.getCnpj())) {
            throw new ValidacaoException("Já existe uma empresa cadastrada com este CNPJ.");
        }
        var empresa = Empresa.of(empresaRequest);
        empresaRepository.save(empresa);
        usuarioService.criarUsuario(empresa, empresaRequest);
        return EmpresaResponse.of(empresa);
    }

    public Empresa obterEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> EX_EMPRESA_NAO_ENCONTRADA);
    }
}
