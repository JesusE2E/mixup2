package unam.diplomado.mixup.creardisco.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;

import java.util.List;
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

    @Override
    public List<Disquera> obtenerTodas() {
        TypedQuery<Disquera> query =
                entityManager.createQuery(
                        "SELECT c FROM Disquera c", Disquera.class);
        return query.getResultList();


    }
}
