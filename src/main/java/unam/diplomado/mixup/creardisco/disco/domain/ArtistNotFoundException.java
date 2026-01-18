package unam.diplomado.mixup.creardisco.disco.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(Integer id) {
        super(
                "El artista con id: "+ id +" no existe"
        );
    }
}
