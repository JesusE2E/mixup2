package unam.diplomado.mixup.creardisco.disco.api.dto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.DomicilioDTO;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.UsuarioRequestDTO;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.UsuarioResponseDTO;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Domicilio;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Usuario;

import java.time.LocalDateTime;
import java.util.Date;


@ApplicationScoped
public class RegistroDiscoMapper {
// de entidad a dto
    public DiscoResponseDTO toDto(Disco disco){
        return new DiscoResponseDTO(
                disco.getTitulo(),
                disco.getImagen(),
                disco.getPrecio(),
                disco.getArtista().getNombre(),
                disco.getDisquera().getNombre(),
                disco.getGeneroMusical().getDescripcion()
        );
    }
//de dto a entidad


    public Disco toDisco(DiscoRequestDTO discoRequestDTO){

        return new Disco(

                discoRequestDTO.getTitulo(),
                discoRequestDTO.getPrecio(),
                discoRequestDTO.getExistencia(),
                discoRequestDTO.getDescuento(),
                discoRequestDTO.getFechaLanzamiento(),
                discoRequestDTO.getImagen(),
                discoRequestDTO.getIdArtista(),
                discoRequestDTO.getIdDisquera(),
                discoRequestDTO.getIdGeneroMusical()

        );
    }

/*
*
*           registroDiscoDTO.getArtistaRequestDTO(),
                registroDiscoDTO.getDisqueraRequestDTO(),
        registroDiscoDTO.getDiscoRequestDTO(),
        registroDiscoDTO.getGeneroMusicalRequestDTO()

*/


}
