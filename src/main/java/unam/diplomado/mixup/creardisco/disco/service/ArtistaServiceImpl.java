package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.repository.ArtistaRepository;

import java.util.List;

@Stateless
public class ArtistaServiceImpl implements ArtistaService {
    @Inject
    ArtistaRepository artistaRepository;

    @Override
    public List<Artista> obtenerTodos() {
        return artistaRepository.obtenerTodos();
    }
}
