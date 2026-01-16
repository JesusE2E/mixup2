package unam.diplomado.mixup.registrarusuario.colonia.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.mixup.registrarusuario.colonia.domain.MunicipioNotFoundException;
@Provider
public class MunicipioNotFoundExeptionMapper implements ExceptionMapper<MunicipioNotFoundException> {




    @Override
    public Response toResponse(MunicipioNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(e.getMessage()).build();
    }
}
