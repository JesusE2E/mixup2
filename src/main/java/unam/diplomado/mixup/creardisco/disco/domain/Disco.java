package unam.diplomado.mixup.creardisco.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id_artista","imagen"})})
public class Disco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    @NotBlank(message = "El precio no puede estar vacio")
    private Double precio;
    private Integer existencia;
    private Double descuento;
    private Date fechaLanzamiento;

    private String imagen;

    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name="id_artista")
    @NotNull(message = "El disco debe estar asociado a un artista existente")
        private Artista artista;

    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name="id_disquera")
    @NotNull(message = "El disco debe estar asociado a una disquera existente")
    private Disquera disquera;

    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name="id_genero_musical")
    @NotNull(message = "El disco debe estar asociado a un genero musical")
    private GeneroMusical generoMusical;

}
