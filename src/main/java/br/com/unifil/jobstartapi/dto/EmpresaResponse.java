package br.com.unifil.jobstartapi.dto;

import br.com.unifil.jobstartapi.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponse {

    private Long id;
    private String nomeRazaoSocial;
    private String localizacao;
    private String cnpj;
    private String telefone;
    private String email;
    private LocalDateTime dataCadastro;

    public static EmpresaResponse of(Empresa empresa) {
        return EmpresaResponse.builder()
                .id(empresa.getId())
                .nomeRazaoSocial(empresa.getNomeRazaoSocial())
                .localizacao(empresa.getLocalizacao())
                .cnpj(empresa.getCnpj())
                .telefone(empresa.getTelefone())
                .email(empresa.getEmail())
                .dataCadastro(empresa.getDataCadastro())
                .build();
    }
}
