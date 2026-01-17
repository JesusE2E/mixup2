package unam.diplomado.mixup.registrarusuario.usuario.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroUsuarioDTO {
    @NotNull(message = "el domicilio es requerido para el registro de usuario")
    @Valid
    private DomicilioDTO domicilio;
    @NotNull(message = "el usuario es requerido para el registro de usuario")
    @Valid
    private UsuarioRequestDTO usuario;
}
