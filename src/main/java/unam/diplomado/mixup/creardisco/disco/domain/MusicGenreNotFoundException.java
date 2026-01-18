package unam.diplomado.mixup.creardisco.disco.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class MusicGenreNotFoundException extends RuntimeException {
    public MusicGenreNotFoundException(Integer id) {
        super("El Genero musical con el id: "+id+" no se existe");
    }
}
