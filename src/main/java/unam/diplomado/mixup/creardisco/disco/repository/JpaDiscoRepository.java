package unam.diplomado.mixup.creardisco.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;

import java.util.List;
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

    @Override
    public Disco save(Disco disco) {
        entityManager.persist(disco);
        return disco;
    }

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        TypedQuery<Disco> query=entityManager.createQuery(

                    "Select d From Disco d where d.titulo=:titulo And d.artista.id=:idArtista"

                ,Disco.class
                );
        query.setParameter("titulo",titulo);
        query.setParameter("idArtista",idArtista);
        List<Disco> discos=query.getResultList();

        return !discos.isEmpty()?Optional.of(discos.get(0)):Optional.empty();

    }
}
