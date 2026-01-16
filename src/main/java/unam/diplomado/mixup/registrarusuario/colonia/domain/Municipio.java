package unam.diplomado.mixup.registrarusuario.colonia.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
        private String nombre;
        @ManyToOne(targetEntity = Estado.class)
        @JoinColumn(name = "id_estado",nullable = false)
        private Estado estado;

}
