package unam.diplomado.mixup.registrarusuario.usuario.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import unam.diplomado.mixup.registrarusuario.usuario.domain.TipoDomicilio;
import unam.diplomado.mixup.registrarusuario.usuario.repository.TipoDomicilioRepository;

import java.util.Collection;

@RequestScoped
public class TipoDomicilioResource  implements TipoDomicilioApi{

    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Override
    public Collection<TipoDomicilio> getAll() {
        return tipoDomicilioRepository.findAll();
    }
/*
    @RequestScoped
    public class TipoDomicilioResource implements TipoDomicilioApi {

        @Inject
        private TipoDomicilioRepository tipoDomicilioRepository;

        @Override
        public Collection<TipoDomicilio> getAll() {
            return tipoDomicilioRepository.findAll();
        }

*/
}

//NoResultExeption