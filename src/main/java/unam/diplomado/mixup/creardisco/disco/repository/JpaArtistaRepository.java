package unam.diplomado.mixup.creardisco.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;


import java.util.List;
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

    @Override
    public List<Artista> obtenerTodos() {
        TypedQuery<Artista> query =
                entityManager.createQuery(
                        "SELECT c FROM Artista c", Artista.class);
        return query.getResultList();

    }
}


