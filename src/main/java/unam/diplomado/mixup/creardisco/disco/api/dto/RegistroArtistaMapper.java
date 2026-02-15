package unam.diplomado.mixup.creardisco.disco.api.dto;

import unam.diplomado.mixup.creardisco.disco.domain.Artista;

public class RegistroArtistaMapper {
    /*De Entidad a DTO */
    public ArtistaResponseDTO toDto(Artista artista){
        return new ArtistaResponseDTO(artista.getNombre());
    }

    /*De DTO Entidad */
    public Artista toArtista(ArtistaRequestDTO artistaRequestDTO){
        return new Artista(null,artistaRequestDTO.getNombre());
    }
}
