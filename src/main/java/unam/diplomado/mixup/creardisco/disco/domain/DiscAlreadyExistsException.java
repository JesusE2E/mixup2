package unam.diplomado.mixup.creardisco.disco.domain;

public class DiscAlreadyExistsException extends RuntimeException {
    public DiscAlreadyExistsException(String titulo,Integer id) {
        super("El disco con nombre: "+titulo+ " y id: "+id+ " ya existe");
    }
}
