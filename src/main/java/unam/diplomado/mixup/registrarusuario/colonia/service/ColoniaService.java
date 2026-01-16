package unam.diplomado.mixup.registrarusuario.colonia.service;

import jakarta.ejb.Local;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;

import java.util.Optional;
@Local
public interface ColoniaService {

    Colonia obtenerColoniaPorId(Integer id) ;
    Colonia crearColonia(Colonia colonia);
    Colonia actualizarColonia(Colonia colonia) ;
    void eliminarColoniaPorId(Integer id);
}
