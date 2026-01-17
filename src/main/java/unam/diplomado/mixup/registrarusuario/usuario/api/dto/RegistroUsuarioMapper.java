package unam.diplomado.mixup.registrarusuario.usuario.api.dto;

import jakarta.enterprise.context.ApplicationScoped;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Domicilio;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Usuario;

@ApplicationScoped
public class RegistroUsuarioMapper {
    public UsuarioResponseDTO toDto(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getEmail()
        );
    }

    public Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO){
        return new Usuario(null,
                usuarioRequestDTO.getNombre(),
                usuarioRequestDTO.getPrimerApellido(),
                usuarioRequestDTO.getSegundoApellido(),
                usuarioRequestDTO.getEmail(),
                usuarioRequestDTO.getPassword(),
                usuarioRequestDTO.getRfc()
                );
    }

    public Domicilio toDomicilio(DomicilioDTO domicilioDTO){
        return new Domicilio(
                domicilioDTO.getCalle(), domicilioDTO.getNumExterior(),
                domicilioDTO.getNumInterior(), domicilioDTO.getColonia(),
                domicilioDTO.getTipoDomicilio());
    }

}
