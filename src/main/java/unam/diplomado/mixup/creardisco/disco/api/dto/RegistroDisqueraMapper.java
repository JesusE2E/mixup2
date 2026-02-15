package unam.diplomado.mixup.creardisco.disco.api.dto;

import unam.diplomado.mixup.creardisco.disco.domain.Disquera;

public class RegistroDisqueraMapper {


    public DisqueraResponseDTO toDto(Disquera disquera){
        return new DisqueraResponseDTO(disquera.getNombre());
    }

    public Disquera toDisquera(DisqueraRequestDTO disqueraRequestDTO){
        return new Disquera(null,disqueraRequestDTO.getNombre());
    }
}
