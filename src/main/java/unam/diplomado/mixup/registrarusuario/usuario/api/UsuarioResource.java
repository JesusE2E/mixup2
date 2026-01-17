package unam.diplomado.mixup.registrarusuario.usuario.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.RegistroUsuarioDTO;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.RegistroUsuarioMapper;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.UsuarioResponseDTO;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Domicilio;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Usuario;
import unam.diplomado.mixup.registrarusuario.usuario.service.UsuarioService;

@RequestScoped
public class UsuarioResource  implements UsuarioApi{

    @Inject
    private UsuarioService usuarioService;
    @Inject
    private RegistroUsuarioMapper mapper;
    @Override
    public Response registroUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        // Transformacion DTO - Entity
        Usuario usuario = mapper.toUsuario(registroUsuarioDTO.getUsuario());
        Domicilio domicilio = mapper.toDomicilio(registroUsuarioDTO.getDomicilio());

        // Invocacion servicio negocio
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario, domicilio);

        // Transformacion Entity - DTO
        UsuarioResponseDTO usuarioResponseDTO = mapper.toDto(usuarioCreado);
        return Response
                .status(Response.Status.CREATED)
                .entity(usuarioResponseDTO)
                .build();
    }
}
