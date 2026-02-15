package unam.diplomado.mixup.creardisco.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.mixup.creardisco.disco.domain.ArtistNotFoundException;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.ErrorResponseDTO;
@Provider
public class ArtistaNotFoundExceptionMapper implements ExceptionMapper<ArtistNotFoundException> {
    @Override
    public Response toResponse(ArtistNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(new ErrorResponseDTO(
                        Response.Status.PRECONDITION_REQUIRED.getStatusCode(),
                        "DATA_INCONSISTENCY",
                        e.getMessage() ))
                .build();
    }
}
