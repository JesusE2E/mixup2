package unam.diplomado.mixup.creardisco.disco.domain;

public class MusicGenreNotFoundException extends RuntimeException {
    public MusicGenreNotFoundException(Integer id) {
        super("El Genero musical con el id: "+id+" no se existe");
    }
}
