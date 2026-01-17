package unam.diplomado.mixup.registrarusuario.usuario.api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioRequestDTO {

   @NotBlank(message = "El nombre es requerido")
    private String nombre;

    private String primerApellido;

    private String segundoApellido;
    private String password;
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message="Formato no válido para Email")
    private String email;
    private String rfc;


}
