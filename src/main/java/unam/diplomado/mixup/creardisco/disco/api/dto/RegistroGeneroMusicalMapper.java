package unam.diplomado.mixup.creardisco.disco.api.dto;

import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;

public class RegistroGeneroMusicalMapper {

    public GeneroMusicalResponseDTO toDto(GeneroMusical generoMusical){
        return new GeneroMusicalResponseDTO(generoMusical.getDescripcion());
    }

    public GeneroMusical toGeneroMusical(GeneroMusicalRequestDTO generoMusicalRequestDTO){
        return new GeneroMusical(
                generoMusicalRequestDTO.getIdGeneroM(),
                generoMusicalRequestDTO.getNombre()
        );
    }
}
