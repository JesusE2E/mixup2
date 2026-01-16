package unam.diplomado.mixup.registrarusuario.colonia.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Municipio;

import java.util.Optional;

@ApplicationScoped
public class JpaMunicipioRepository  implements  MunicipioRepository{

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Municipio> findById(Integer id) {

        Municipio municipio = entityManager.find(Municipio.class, id);
        return municipio != null ? Optional.of(municipio) : Optional.empty();
    }
}
