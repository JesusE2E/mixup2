package unam.diplomado.mixup.registrarusuario.colonia.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class ColoniaAlreadyExistsException extends RuntimeException {
public ColoniaAlreadyExistsException(String cp,String nombre){
    super("Ya existe una colonia con el nombre: "+nombre + "y el codigo Postal: ");
}

}
