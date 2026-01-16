package unam.diplomado.mixup.creardisco.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import unam.diplomado.mixup.creardisco.disco.domain.Disquera;

import java.util.Optional;
@ApplicationScoped
public class JpaDisqueraRepository implements DisqueraRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;
    @Override
    public Optional<Disquera> findById(Integer id) {
        Disquera disquera = entityManager.find(Disquera.class, id);
        return disquera != null ? Optional.of(disquera) : Optional.empty();
    }
}
