package unam.diplomado.mixup.registrarusuario.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.registrarusuario.colonia.api.dto.ColoniaDTO;
import unam.diplomado.mixup.registrarusuario.colonia.api.dto.ColoniaMapper;
import unam.diplomado.mixup.registrarusuario.colonia.api.dto.ColoniaRequestDTO;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;
import unam.diplomado.mixup.registrarusuario.colonia.domain.ColoniaAlreadyExistsException;
import unam.diplomado.mixup.registrarusuario.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.mixup.registrarusuario.colonia.repository.ColoniaRepository;
import unam.diplomado.mixup.registrarusuario.colonia.service.ColoniaService;

import java.util.*;

@RequestScoped
public class ColoniaResource implements ColoniaApi{


    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private ColoniaService coloniaService;
    @Inject
    private ColoniaMapper coloniaMapper;

    @Override
    public Colonia getColoniaById(Integer id) {
        return coloniaService.obtenerColoniaPorId(id);
    }

    @Override
    public Response createColonia(ColoniaRequestDTO coloniaRequestDTO) {
        // Transformacion DTO - Entity
        Colonia colonia = coloniaMapper.toColonia(coloniaRequestDTO);
        Colonia coloniaCreada = coloniaService.crearColonia(colonia);
        return Response
                .status(Response.Status.CREATED)
                .entity(coloniaCreada)
                .build();
    }

    @Override
    public Collection<ColoniaDTO> getColoniasByCp(String cp) {
        /*
        Collection<Colonia> colonias = coloniaRepository.findByCp(cp);
        Collection<ColoniaDTO> coloniasDTO = new ArrayList<>();
        for (Colonia colonia: colonias) {
            coloniasDTO.add(coloniaMapper.toDto(colonia));
        }
        return coloniasDTO;
         */
        return coloniaRepository
                .findByCp(cp)
                .stream()
                .map(colonia -> coloniaMapper.toDto(colonia))
                .toList();
    }

    @Override
    public void deleteColonia(Integer id) {
        coloniaService.eliminarColoniaPorId(id);
    }

    @Override
    public Colonia updateColonia(Integer id, Colonia colonia) {
        colonia.setId(id);
        return coloniaService.actualizarColonia(colonia);
    }

}





















