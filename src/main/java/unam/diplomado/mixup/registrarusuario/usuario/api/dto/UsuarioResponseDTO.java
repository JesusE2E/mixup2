package unam.diplomado.mixup.registrarusuario.usuario.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Integer id;
    private String email;
}
