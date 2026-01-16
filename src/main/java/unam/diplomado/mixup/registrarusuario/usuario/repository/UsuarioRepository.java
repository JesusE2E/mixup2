package unam.diplomado.mixup.registrarusuario.usuario.repository;

import unam.diplomado.mixup.registrarusuario.usuario.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);
    Optional<Usuario> findByEmail(String email);
}
