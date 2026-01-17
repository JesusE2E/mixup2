package unam.diplomado.mixup.registrarusuario.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.ErrorResponseDTO;
import unam.diplomado.mixup.registrarusuario.usuario.domain.UsuarioAlreadyExistsException;
@Provider
public class UsuarioAlreadyExistsExceptionMapper implements ExceptionMapper<UsuarioAlreadyExistsException> {
    @Override
    public Response toResponse(UsuarioAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(new ErrorResponseDTO(
                        Response.Status.CONFLICT.getStatusCode(),
                        "BUSINESS_RULE",
                        e.getMessage()))
                .build();
    }
}
