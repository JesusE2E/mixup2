package unam.diplomado.mixup.creardisco.disco.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscoResponseDTO {

    private String titulo;
    private String imagen;
    private Double precio;
    private String artistaNombre;
    private String disqueraNombre;
    private String generoMusical;


}
