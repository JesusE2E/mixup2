package unam.diplomado.mixup.creardisco.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.creardisco.disco.domain.*;
import unam.diplomado.mixup.creardisco.disco.repository.DiscoRepository;

import unam.diplomado.mixup.creardisco.disco.service.DiscoService;
import unam.diplomado.mixup.registrarusuario.colonia.domain.ColoniaAlreadyExistsException;

@RequestScoped
public class DiscoResource implements DiscoApi{
    @Inject
    private DiscoService discoService;
    @Inject
    private DiscoRepository discoRepository;


    @Override
    public Response altaDisco(Disco disco) {

        // HTTP 400 (Bad Request) para el escenario cuando los campos no cumplan con validaciones de formato.

       //http 422 (Unprocessable Content) o 428  (Precondition Required) para los escenarios donde no exista el artista, disquera o género musical.

        //http Conflict 409 el disco ya existe en el catalogo

        //Escenario exitoso http 201 Created


          //  discoService.registrarDisco(disco);
        try{
            Disco disco1=discoService.registrarDisco(disco);
            return Response.status(Response.Status.CREATED).entity(disco1).build();

        } catch (DiscAlreadyExistsException e) {

                return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
            }catch (ArtistNotFoundException | MusicGenreNotFoundException | RecordLabelNotFoundException e){
            return Response.status(Response.Status.PRECONDITION_REQUIRED).entity(e.getMessage()).build();
        }

        }





    }


