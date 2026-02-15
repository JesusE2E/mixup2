package unam.diplomado.mixup.creardisco.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.mixup.creardisco.disco.domain.DiscAlreadyExistsException;
import unam.diplomado.mixup.creardisco.disco.domain.FormatNotFoundException;
import unam.diplomado.mixup.creardisco.disco.domain.MusicGenreNotFoundException;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.ErrorResponseDTO;
@Provider
public class FormatNotFoundExceptionMapper implements ExceptionMapper<FormatNotFoundException> {


    @Override
    public Response toResponse(FormatNotFoundException e) {
        return Response
                .status(Response.Status.BAD_REQUEST.getStatusCode())
                .entity(new ErrorResponseDTO(
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        "BAD REQUEST",
                        e.getMessage() ))
                .build();
    }
}




