package unam.diplomado.mixup.creardisco.disco.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDiscoDTO {
   /*Borrar esta clase porque esta repetida*/
private Integer idArtista;
private Integer idGeneroMusical;
private Integer idDisquera;
private String titulo;
private Double precio;
private Double descuento;
private Integer Existencia;
private LocalDateTime fechaLanzamiento;
   private String imagen;
 }

