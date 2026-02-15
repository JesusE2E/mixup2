package unam.diplomado.mixup.creardisco.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.mixup.creardisco.disco.domain.DiscAlreadyExistsException;
import unam.diplomado.mixup.creardisco.disco.domain.MusicGenreNotFoundException;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.ErrorResponseDTO;
@Provider
public class MusicGenreNotFoundExceptionMapper implements ExceptionMapper<MusicGenreNotFoundException> {


    @Override
    public Response toResponse(MusicGenreNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(new ErrorResponseDTO(
                        Response.Status.PRECONDITION_REQUIRED.getStatusCode(),
                        "DATA_INCONSISTENCY",
                        e.getMessage() ))
                .build();
    }
}
