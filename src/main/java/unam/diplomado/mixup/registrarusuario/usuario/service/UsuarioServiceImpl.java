package unam.diplomado.mixup.registrarusuario.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;
import unam.diplomado.mixup.registrarusuario.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.mixup.registrarusuario.colonia.repository.ColoniaRepository;
import unam.diplomado.mixup.registrarusuario.usuario.domain.*;
import unam.diplomado.mixup.registrarusuario.usuario.repository.DomicilioRepository;
import unam.diplomado.mixup.registrarusuario.usuario.repository.UsuarioRepository;
import unam.diplomado.mixup.registrarusuario.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.mixup.registrarusuario.usuario.service.messaging.NotificacionProducer;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    private DomicilioRepository domicilioRepository;
    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;
    @Inject
    private ColoniaRepository coloniaRepository;

    @Inject
    private NotificacionProducer notificacionProducer;


    @Override
    @Transactional(value=Transactional.TxType.REQUIRED)
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
        /*
         * Validacion de usuario duplicado
         * */
        Optional<Usuario>usuarioExistente= usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioExistente.isPresent()){
throw  new UsuarioAlreadyExistsException(usuario.getEmail());
        }
        //validacion de colonia
        Optional<Colonia> coloniaExistente=
                coloniaRepository.findById(domicilio.getColonia().getId());
        if(coloniaExistente.isEmpty()){
            throw  new ColoniaNotFoundException(domicilio.getColonia().getId());
        }

        domicilio.setColonia(coloniaExistente.get());
        //validacion tipo de domicilio
        Optional<TipoDomicilio> tipoDomicilioExistente=tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
        if(tipoDomicilioExistente.isEmpty()){
            throw  new TipoDomicilioNotFoundException(domicilio.getTipoDomicilio().getId());
        }
        domicilio.setTipoDomicilio(tipoDomicilioExistente.get());

        //persistencia guardado de entidades
        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);
        notificacionProducer.enviarNotificacionAltaUsuario(usuario.getId(),usuario.getEmail());
        return usuario;
    }
}
