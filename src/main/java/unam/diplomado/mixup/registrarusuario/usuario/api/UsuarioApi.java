package unam.diplomado.mixup.registrarusuario.usuario.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.RegistroUsuarioDTO;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.UsuarioRequestDTO;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("usuarios")
public interface UsuarioApi {
    @POST
    @Path("registro")//conotacion de negocio, descripcion de la operacion de negocio
 Response registroUsuario(@NotNull @Valid RegistroUsuarioDTO registroUsuarioDTO);
}
