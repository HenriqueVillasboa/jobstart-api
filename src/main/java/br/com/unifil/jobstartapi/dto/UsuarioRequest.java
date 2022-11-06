package br.com.unifil.jobstartapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotEmpty
    @NotBlank
    private String login;

    @NotEmpty
    @NotBlank
    private String senha;
}
