package br.com.unifil.jobstartapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

    @NotEmpty
    private String nomeRazaoSocial;

    @NotEmpty
    private String localizacao;

    @CNPJ
    @NotEmpty
    private String cnpj;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String email;

    @NotEmpty
    private String senha;
}
