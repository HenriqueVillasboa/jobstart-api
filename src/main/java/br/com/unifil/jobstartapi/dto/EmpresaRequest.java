package br.com.unifil.jobstartapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

    @NotEmpty
    @NotBlank
    private String nomeRazaoSocial;

    @NotEmpty
    @NotBlank
    private String cidade;

    @CNPJ
    @NotEmpty
    @NotBlank
    private String cnpj;

    @NotEmpty
    @NotBlank
    private String telefone;

    @Email
    @NotEmpty
    @NotBlank
    private String email;

    @NotEmpty
    @NotBlank
    private String senha;
}
