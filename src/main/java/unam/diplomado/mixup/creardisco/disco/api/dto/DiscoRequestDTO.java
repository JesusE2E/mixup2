package unam.diplomado.mixup.creardisco.disco.api.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscoRequestDTO {


    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    @NotNull(message = "El precio no puede estar vacio")
    private Double precio;
    private Integer existencia;

    private Double descuento;
    private Date fechaLanzamiento;

    private String imagen;
    //@NotNull(message = "El disco debe estar asociado a un artista existente")
   private Integer idArtista;
    @NotNull(message = "El disco debe estar asociado a una disquera existente")
   private Integer idDisquera;
    @NotNull(message = "El disco debe estar asociado a un genero musical")
    private Integer idGeneroMusical;

}
