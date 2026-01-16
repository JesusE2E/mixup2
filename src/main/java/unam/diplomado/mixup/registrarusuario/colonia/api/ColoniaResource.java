package unam.diplomado.mixup.registrarusuario.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.registrarusuario.colonia.api.dto.ColoniaDTO;
import unam.diplomado.mixup.registrarusuario.colonia.api.dto.ColoniaMapper;
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

        /*
 Colonia colonia =coloniaService.obtenerColoniaPorId(id);
 if(colonia!=null){
    return Response.status(Response.Status.OK)
             .entity(colonia)
             .build();
 }
return Response.status(Response.Status.NOT_FOUND)
                .entity(null)
                .build();
*/

      /*  try {
            Colonia colonia = coloniaService.obtenerColoniaPorId(id);
            return Response
                    .status(Response.Status.OK)
                    .entity(colonia)
                    .build();
        } catch (ColoniaNotFoundException e) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(e.getCause().getMessage())
                    .build();
        }

*/
   /*     Optional<Colonia> colonia =coloniaRepository.findById(id);
        //return colonia.orElse(null); constructo de manera reactiva. implementacion

        if(colonia.isPresent()){
            return colonia.get();
        }
        return null;*/
    }

    @Override
    public Collection<ColoniaDTO> getColoniasByCp(String cp) {
        Collection<Colonia> colonias= coloniaRepository.findByCp(cp);
        Collection<ColoniaDTO> coloniasDTO=new ArrayList<>();
        for (Colonia colonia: colonias){
    coloniasDTO.add(coloniaMapper.toDto(colonia));
}
 /*
        //lo mismo en programacion reactiva
        coloniaRepository
                .findByCp(cp)
                .stream()
                .map(x->coloniaMapper.toDto(x))
                .toList();
        */
    return coloniasDTO;

    }

    @Override
    public void deleteColonia(Integer id) {
        coloniaService.eliminarColoniaPorId(id);

    }

    @Override
    public Response createColonia(Colonia colonia) {
        Colonia coloniaCreada = coloniaService.crearColonia(colonia);
        return Response
                .status(Response.Status.CREATED)
                .entity(coloniaCreada)
                .build();

  /*     try{
           Colonia coloniaCreada = coloniaService.crearColonia(colonia);
           return Response
                   .status(Response.Status.CREATED)
                   .entity(coloniaCreada)
                   .build();
       } catch (Exception e) {
           if(e instanceof ColoniaAlreadyExistsException){
               return Response
                       .status(Response.Status.CONFLICT)
                       .entity(e.getMessage())
                       .build();

           }
           return Response.status(Response.Status.PRECONDITION_REQUIRED)
                   .entity(e.getMessage()).build();
       }*/
    }

    @Override
    public Colonia updateColonia(Integer id, Colonia colonia) {
        colonia.setId(id);
        return coloniaService.actualizarColonia(colonia);
    }

    /// ////
    /*
    public Colonia getColoniaById(Integer id){
        Optional<Colonia> colonia=coloniaRepository.findById(id);
        if(colonia.isPresent().get());
    }

    */
}





















