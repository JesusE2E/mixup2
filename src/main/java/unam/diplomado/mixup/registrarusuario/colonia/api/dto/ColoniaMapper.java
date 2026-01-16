package unam.diplomado.mixup.registrarusuario.colonia.api.dto;

import jakarta.enterprise.context.ApplicationScoped;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;
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
}
