package unam.diplomado.mixup.creardisco.disco.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response;
//import jakarta.xml.ws.Response;
import unam.diplomado.mixup.creardisco.disco.api.dto.DiscoRequestDTO;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;
import unam.diplomado.mixup.registrarusuario.colonia.api.dto.ColoniaDTO;
import unam.diplomado.mixup.registrarusuario.colonia.api.dto.ColoniaRequestDTO;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("discos")
public interface DiscoApi {
    @POST
    @Path("alta")
    Response altaDisco(@NotNull @Valid DiscoRequestDTO discoRequestDTO);

}



