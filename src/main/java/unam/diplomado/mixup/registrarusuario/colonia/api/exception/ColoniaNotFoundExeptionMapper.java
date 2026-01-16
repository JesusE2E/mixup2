package unam.diplomado.mixup.registrarusuario.colonia.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.mixup.registrarusuario.colonia.domain.ColoniaNotFoundException;

@Provider
public class ColoniaNotFoundExeptionMapper implements ExceptionMapper<ColoniaNotFoundException> {
    @Override
    public Response toResponse(ColoniaNotFoundException e) {
         return Response.status(Response.Status.NOT_FOUND)
                .entity(e.getMessage()).build();
    }
}
