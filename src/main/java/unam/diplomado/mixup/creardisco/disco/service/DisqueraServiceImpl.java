package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.repository.DisqueraRepository;

import java.util.List;

@Stateless
public class DisqueraServiceImpl implements DisqueraService{
  @Inject
    private DisqueraRepository disqueraRepository;

    @Override
    public List<Disquera> obtenerDisqueras() {
        return disqueraRepository.obtenerTodas();
    }
}
