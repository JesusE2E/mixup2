package unam.diplomado.mixup.registrarusuario.usuario.service;

import jakarta.ejb.Local;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Domicilio;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Usuario;

@Local
public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);
}
