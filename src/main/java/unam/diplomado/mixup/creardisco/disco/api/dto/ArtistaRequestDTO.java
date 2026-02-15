package unam.diplomado.mixup.creardisco.disco.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistaRequestDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
}
