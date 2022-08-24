package br.com.unifil.jobstartapi.dto;

import br.com.unifil.jobstartapi.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private Long id;
    private Long empresaId;
    private String empresaNome;
    private String login;
    private Boolean ativo;
    private String email;
    private LocalDateTime dataCadastro;

    public static UsuarioResponse of(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .empresaId(usuario.getEmpresa().getId())
                .empresaNome(usuario.getEmpresa().getNomeRazaoSocial())
                .login(usuario.getLogin())
                .ativo(usuario.getAtivo())
                .email(usuario.getEmail())
                .dataCadastro(usuario.getDataCadastro())
                .build();
    }
}
