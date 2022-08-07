package br.com.unifil.jobstartapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String descricao;

    @NotEmpty
    private String cargo;

    @Positive
    private Double salario;

    @NotEmpty
    private String areaAtuacao;
}
