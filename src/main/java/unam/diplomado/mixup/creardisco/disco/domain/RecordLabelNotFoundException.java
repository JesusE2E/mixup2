package unam.diplomado.mixup.creardisco.disco.domain;

public class RecordLabelNotFoundException extends RuntimeException {
    public RecordLabelNotFoundException(Integer id) {
        super(
                "La disquera con id: "+id+ " no existe en la bd");
    }
}
