package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Local;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;

@Local
public interface DiscoService {
    Disco registrarDisco(Disco disco);
}
