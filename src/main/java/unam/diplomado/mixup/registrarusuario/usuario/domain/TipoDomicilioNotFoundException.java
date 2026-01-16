package unam.diplomado.mixup.registrarusuario.usuario.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class TipoDomicilioNotFoundException extends RuntimeException {
    public TipoDomicilioNotFoundException(Integer id) {
        super("No se encontro un tipo domicilio con "+id);
    }
}
