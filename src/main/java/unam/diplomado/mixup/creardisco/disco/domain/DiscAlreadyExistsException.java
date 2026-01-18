package unam.diplomado.mixup.creardisco.disco.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class DiscAlreadyExistsException extends RuntimeException {
    public DiscAlreadyExistsException(String titulo,Integer id) {
        super("El disco con nombre: "+titulo+ " y id: "+id+ " ya existe");
    }
}
