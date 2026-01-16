package unam.diplomado.mixup.creardisco.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;


import java.util.Optional;
@ApplicationScoped
public class JpaArtistaRepository implements ArtistaRepository{
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Artista> findById(Integer id) {

        Artista artista = entityManager.find(Artista.class, id);
        return artista != null ? Optional.of(artista) : Optional.empty();
    }
}
