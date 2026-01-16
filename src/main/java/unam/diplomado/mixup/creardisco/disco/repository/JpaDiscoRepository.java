package unam.diplomado.mixup.creardisco.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import unam.diplomado.mixup.creardisco.disco.domain.Disco;

import java.util.Optional;
@ApplicationScoped
public class JpaDiscoRepository implements DiscoRepository{
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disco> findById(Integer id) {

        Disco disco = entityManager.find(Disco.class, id);
        return disco != null ? Optional.of(disco) : Optional.empty();
    }
}
