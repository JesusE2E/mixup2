package unam.diplomado.mixup.creardisco.disco.repository;

import unam.diplomado.mixup.creardisco.disco.domain.Artista;

import java.util.Optional;

public interface ArtistaRepository {
    Optional<Artista> findById(Integer id);
}
