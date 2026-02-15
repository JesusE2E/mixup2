package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;
import unam.diplomado.mixup.creardisco.disco.repository.ArtistaRepository;
import unam.diplomado.mixup.creardisco.disco.repository.GeneroMusicalRepository;

import java.util.List;

@Stateless
public class GeneroMusicalServiceImpl implements GeneroMusicalService {
    @Inject
    GeneroMusicalRepository generoMusicalRepository;

    @Override
    public List<GeneroMusical> obtenerTodos() {
        return generoMusicalRepository.obtenerTodos();
    }
}
