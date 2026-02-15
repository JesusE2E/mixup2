package unam.diplomado.mixup.creardisco.disco.repository;

import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;

import java.util.List;
import java.util.Optional;

public interface GeneroMusicalRepository {
    Optional<GeneroMusical> findById(Integer id);
    List<GeneroMusical> obtenerTodos();
}
