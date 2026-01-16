package unam.diplomado.mixup.registrarusuario.usuario.repository;

import unam.diplomado.mixup.registrarusuario.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.Optional;

public interface TipoDomicilioRepository {
    Collection findAll();
    Optional<TipoDomicilio> findById(Integer id);
}
