package unam.diplomado.mixup.registrarusuario.usuario.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.mixup.registrarusuario.usuario.domain.Domicilio;

@ApplicationScoped
public class JpaDomicilioRepository  implements DomicilioRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Domicilio save(Domicilio domicilio) {
        entityManager.persist(domicilio);
        return domicilio;
    }
}
/////////////////////////////////////////