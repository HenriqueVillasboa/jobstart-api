package br.com.unifil.jobstartapi.dto;

import br.com.unifil.jobstartapi.model.Vaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VagaResponse {

    private Long id;
    private EmpresaResponse empresa;
    private String descricao;
    private String cargo;
    private Double salario;
    private String areaAtuacao;
    private LocalDateTime dataCadastro;

    public static VagaResponse of(Vaga vaga) {
        var vagaResponse = new VagaResponse();
        BeanUtils.copyProperties(vaga, vagaResponse);
        vagaResponse.setEmpresa(EmpresaResponse.of(vaga.getEmpresa()));
        return vagaResponse;
    }
}
