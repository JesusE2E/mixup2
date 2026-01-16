package unam.diplomado.mixup.registrarusuario.usuario.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.mixup.registrarusuario.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
public class JpaTipoDomicilioRepository implements TipoDomicilioRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection findAll() {
        TypedQuery<TipoDomicilio> query= entityManager.createQuery(
                "SELECT td FROM TipoDomicilio td",
                TipoDomicilio.class
        );

        return query.getResultList();
    }

    @Override
    public Optional<TipoDomicilio> findById(Integer id) {
        TipoDomicilio tipoDomicilio=entityManager.find(TipoDomicilio.class,id);
        return tipoDomicilio!=null? Optional.of(tipoDomicilio):Optional.empty();
    }


}
