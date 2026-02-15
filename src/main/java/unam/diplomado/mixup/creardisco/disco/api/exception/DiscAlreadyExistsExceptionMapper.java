package unam.diplomado.mixup.creardisco.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.mixup.creardisco.disco.domain.ArtistNotFoundException;
import unam.diplomado.mixup.creardisco.disco.domain.DiscAlreadyExistsException;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.ErrorResponseDTO;
@Provider
public class DiscAlreadyExistsExceptionMapper implements ExceptionMapper<DiscAlreadyExistsException> {

    @Override
    public Response toResponse(DiscAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(new ErrorResponseDTO(
                        Response.Status.CONFLICT.getStatusCode(),
                        "CONFLICT",
                        e.getMessage() ))
                .build();
    }
}
