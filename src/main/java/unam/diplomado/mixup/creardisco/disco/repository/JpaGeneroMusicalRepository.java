package unam.diplomado.mixup.creardisco.disco.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;

import java.util.List;
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

    @Override
    public List<GeneroMusical> obtenerTodos() {
        TypedQuery<GeneroMusical> query =
                entityManager.createQuery(
                        "SELECT c FROM GeneroMusical c", GeneroMusical.class);
        return query.getResultList();
    }
}
