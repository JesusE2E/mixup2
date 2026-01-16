package unam.diplomado.mixup.registrarusuario.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;
import unam.diplomado.mixup.registrarusuario.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.mixup.registrarusuario.colonia.repository.ColoniaRepository;
import unam.diplomado.mixup.registrarusuario.usuario.domain.*;
import unam.diplomado.mixup.registrarusuario.usuario.repository.DomicilioRepository;
import unam.diplomado.mixup.registrarusuario.usuario.repository.UsuarioRepository;
import unam.diplomado.mixup.registrarusuario.usuario.repository.TipoDomicilioRepository;

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


    @Override
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
        return usuario;
    }
}
