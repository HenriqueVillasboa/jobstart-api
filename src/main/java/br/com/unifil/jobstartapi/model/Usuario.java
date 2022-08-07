package br.com.unifil.jobstartapi.model;

import br.com.unifil.jobstartapi.dto.UsuarioRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @NotEmpty
    private String nome;

    @NotEmpty
    private String senha;

    private Boolean ativo;

    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;

    private LocalDateTime dataCadastro;

    public static Usuario of(UsuarioRequest usuarioRequest) {
        return Usuario.builder()
                .empresa(Empresa.ofId(usuarioRequest.getEmpresaId()))
                .nome(usuarioRequest.getNome())
                .senha(usuarioRequest.getSenha())
                .email(usuarioRequest.getEmail())
                .ativo(Boolean.TRUE)
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
