package br.com.unifil.jobstartapi.model;

import br.com.unifil.jobstartapi.dto.VagaRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EMPRESA_ID")
    private Empresa empresa;

    private String descricao;

    private String cargo;

    private Double salario;

    private String areaAtuacao;

    private LocalDateTime dataCadastro;

    public static Vaga of(VagaRequest vagaRequest) {
        return Vaga.builder()
                .empresa(Empresa.ofId(vagaRequest.getEmpresaId()))
                .descricao(vagaRequest.getDescricao().toUpperCase())
                .cargo(vagaRequest.getCargo().toUpperCase())
                .salario(vagaRequest.getSalario())
                .areaAtuacao(vagaRequest.getAreaAtuacao().toUpperCase())
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
