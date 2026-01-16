package unam.diplomado.mixup.registrarusuario.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tipo_domicilio")
@NoArgsConstructor
@Data
public class TipoDomicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @OneToMany(mappedBy = "tipoDomicilio")
    private List<Domicilio> domicilios;



}
