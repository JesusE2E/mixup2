package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Local;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;

import java.util.List;

@Local
public interface GeneroMusicalService {
    List<GeneroMusical> obtenerTodos();
}
