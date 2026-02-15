package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Local;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;

import java.util.List;

@Local
public interface DisqueraService
{
    List<Disquera> obtenerDisqueras();

}
