package br.com.unifil.jobstartapi.model;

import br.com.unifil.jobstartapi.dto.EmpresaRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeRazaoSocial;

    private String localizacao;

    @Column(unique = true)
    private String cnpj;

    @Size(min=10, max=11)
    private String telefone;

    @Column(unique = true)
    private String email;

    private LocalDateTime dataCadastro;

    public static Empresa of(EmpresaRequest empresaRequest) {
        return Empresa.builder()
                .nomeRazaoSocial(empresaRequest.getNomeRazaoSocial().toUpperCase())
                .localizacao(empresaRequest.getLocalizacao().toUpperCase())
                .cnpj(empresaRequest.getCnpj())
                .telefone(empresaRequest.getTelefone())
                .email(empresaRequest.getEmail().toUpperCase())
                .dataCadastro(LocalDateTime.now())
                .build();
    }

    public static Empresa ofId(Long empresaId) {
        return Empresa.builder()
                .id(empresaId)
                .build();
    }
}
