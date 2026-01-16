package unam.diplomado.mixup.registrarusuario.colonia.repository;

import unam.diplomado.mixup.registrarusuario.colonia.domain.Municipio;

import java.util.Optional;

public interface MunicipioRepository {

    Optional<Municipio> findById(Integer id);
}
