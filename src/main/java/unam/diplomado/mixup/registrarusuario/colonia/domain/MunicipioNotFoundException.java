package unam.diplomado.mixup.registrarusuario.colonia.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class MunicipioNotFoundException extends  RuntimeException{
    public MunicipioNotFoundException(Integer id) {
        super("No existe el municipio con Id "+id);
    }
}
