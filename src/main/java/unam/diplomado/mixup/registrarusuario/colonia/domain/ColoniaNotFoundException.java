package unam.diplomado.mixup.registrarusuario.colonia.domain;

import jakarta.ejb.ApplicationException;
//no se debe encapsular la exception en una Excepcion EJB
@ApplicationException
public class ColoniaNotFoundException  extends RuntimeException{
    public ColoniaNotFoundException(Integer id){
        super("No se encontró la colonia con id:" +id);
    }
}
//NoResultException