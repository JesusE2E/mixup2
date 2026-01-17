package unam.diplomado.mixup.registrarusuario.usuario.service.messaging;

import jakarta.ejb.Local;

@Local
public interface NotificacionProducer {
   boolean enviarNotificacionAltaUsuario(Integer id,String email);
}
