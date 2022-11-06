package br.com.unifil.jobstartapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VagaRequest {

    @NotNull
    private Long empresaId;

    @NotEmpty
    @NotBlank
    private String cargo;

    @Positive
    @NotBlank
    private Double salario;

    @NotEmpty
    @NotBlank
    private String areaAtuacao;

    private String requisitos;

    private String beneficios;
}
