package br.com.unifil.jobstartapi.service;

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

    @Transactional(readOnly = true)
    public List<EmpresaResponse> listarEmpresas() {
        return empresaRepository.findAll()
                .stream()
                .map(EmpresaResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public EmpresaResponse criarEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
        return EmpresaResponse.of(empresa);
    }

    public Empresa obterEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> EX_EMPRESA_NAO_ENCONTRADA);
    }

    public Empresa obterEmpresaPorCnpj(String cnpj) {
        return empresaRepository.findByCnpj(cnpj)
                .orElseThrow(() -> EX_EMPRESA_NAO_ENCONTRADA);
    }
}
