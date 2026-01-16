package unam.diplomado.mixup.creardisco.disco.repository;

import unam.diplomado.mixup.creardisco.disco.domain.Disco;

import java.util.Optional;

public interface DiscoRepository {
    Optional<Disco> findById(Integer id);
}
