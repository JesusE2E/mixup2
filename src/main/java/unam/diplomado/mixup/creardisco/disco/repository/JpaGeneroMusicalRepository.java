package unam.diplomado.mixup.creardisco.disco.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;

import java.util.Optional;
@ApplicationScoped
public class JpaGeneroMusicalRepository implements GeneroMusicalRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<GeneroMusical> findById(Integer id) {
        GeneroMusical generoMusical = entityManager.find(GeneroMusical.class, id);
        return generoMusical != null ? Optional.of(generoMusical) : Optional.empty();
    }
}
