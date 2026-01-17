package unam.diplomado.mixup.registrarusuario.usuario.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomicilioDTO {
    @NotBlank(message = "Calle es requerida ")
    private String calle;
    private Integer numExterior;
    private Integer numInterior;
    @NotNull(message = "Colonia es requerida")
    private Integer colonia;
    private Integer tipoDomicilio;

}
