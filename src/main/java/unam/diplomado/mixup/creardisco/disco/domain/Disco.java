package unam.diplomado.mixup.creardisco.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id_artista","titulo"})})
public class Disco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private Double precio;
    @NotNull(message = "Se debe ingresar un valor valido para la cantidad en existencia")
    private Integer existencia;
    private Double descuento;
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;
    @Pattern(
            regexp = "^www.*$",
            message = "Formato no válido: la imagen debe comenzar con www"
    )
    private String imagen;

    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name="id_artista")
    @NotNull(message = "El disco debe estar asociado a un artista existente")
        private Artista artista;

    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name="id_disquera")
    @NotNull(message = "El disco debe estar asociado a una disquera existente")
    private Disquera disquera;

    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name="id_genero_musical")
    @NotNull(message = "El disco debe estar asociado a un genero musical")
    private GeneroMusical generoMusical;

}
