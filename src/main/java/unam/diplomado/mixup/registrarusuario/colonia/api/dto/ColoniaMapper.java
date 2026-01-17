package unam.diplomado.mixup.registrarusuario.colonia.api.dto;

import jakarta.enterprise.context.ApplicationScoped;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Municipio;

@ApplicationScoped
public class ColoniaMapper {
    public ColoniaDTO toDto(Colonia colonia){
        return new ColoniaDTO(
                colonia.getId(),
                colonia.getNombre(),
                colonia.getCodigoPostal(),
                colonia.getMunicipio().getNombre(),
                colonia.getMunicipio().getEstado().getNombre()

        );

    }

    public Colonia toColonia(ColoniaRequestDTO coloniaRequestDTO){
        Colonia colonia=new Colonia();
        colonia.setNombre(coloniaRequestDTO.nombre());
        colonia.setCodigoPostal(coloniaRequestDTO.cp());
        colonia.setMunicipio(new Municipio());
        colonia.getMunicipio().setId(coloniaRequestDTO.municipio());

return colonia;
    }





}

