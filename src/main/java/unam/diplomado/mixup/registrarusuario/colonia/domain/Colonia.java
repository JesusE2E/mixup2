package unam.diplomado.mixup.registrarusuario.colonia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Colonia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    //validar con una expresion regular
    @Pattern(regexp="^(\\d{5}$)",
            message="Formato no válido para código postal")
    @Column(name="cp")
    private String codigoPostal;
    //Validacion para verificar que el campo no es nulo
    // el mensaje de error se muestra a continuacion
    @NotBlank(message="Nombre es requerido")
    private String nombre;

    @ManyToOne(targetEntity = Municipio.class)
    @JoinColumn(name = "id_municipio")
    @NotNull(message = "La colonia debe estar asociada a un municipio")
    private Municipio municipio;
}
