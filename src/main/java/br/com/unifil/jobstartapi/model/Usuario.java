package br.com.unifil.jobstartapi.model;

import br.com.unifil.jobstartapi.dto.EmpresaRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPRESA_ID")
    private Empresa empresa;

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    private Boolean ativo;

    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;

    private LocalDateTime dataCadastro;

    public static Usuario of(Empresa empresa, EmpresaRequest empresaRequest) {
        return Usuario.builder()
                .empresa(empresa)
                .login(empresa.getCnpj())
                .email(empresa.getEmail())
                .senha(empresaRequest.getSenha())
                .ativo(Boolean.TRUE)
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
