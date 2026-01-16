package unam.diplomado.mixup.registrarusuario.usuario.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class UsuarioAlreadyExistsException extends RuntimeException {
    public UsuarioAlreadyExistsException(String email) {
        super("Ya existe el usuario en la bd: "+email);
    }
}
