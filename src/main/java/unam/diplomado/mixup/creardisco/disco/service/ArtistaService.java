package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Local;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;

import java.util.List;

@Local
public interface ArtistaService {
    List<Artista> obtenerTodos();
}
