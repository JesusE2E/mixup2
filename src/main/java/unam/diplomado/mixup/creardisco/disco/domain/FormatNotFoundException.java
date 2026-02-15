package unam.diplomado.mixup.creardisco.disco.domain;

public class FormatNotFoundException extends RuntimeException {
    public FormatNotFoundException(Integer id) {
        super(
               "El formato de los datos no es valido"
        );
    }
}
