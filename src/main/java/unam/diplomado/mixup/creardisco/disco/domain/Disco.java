package unam.diplomado.mixup.creardisco.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    @NotNull(message = "El precio no puede estar vacio")
    private Double precio;
    private Integer existencia;
    private Double descuento;
    @Column(name="fecha_lanzamiento")
    private Date fechaLanzamiento;

    private String imagen;

    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name="id_artista")
    @NotNull(message = "El disco debe estar asociado a un artista existente")
        private Artista artista;

    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name="id_disquera")
    @NotNull(message = "El disco debe estar asociado a una disquera existente")
    private Disquera disquera;

    @ManyToOne(targetEntity =GeneroMusical.class)
    @JoinColumn(name="id_genero_musical")
    @NotNull(message = "El disco debe estar asociado a un genero musical")
    private GeneroMusical generoMusical;

    public Disco(
             String titulo,
             Double precio,
             Integer existencia,
             Double descuento,
             Date fechaLanzamiento,
             String imagen,
             Integer idArtista,
             Integer idDisquera,
             Integer idGeneroMusical) {
        this.titulo=titulo;
        this.precio=precio;
        this.existencia=existencia;
        this.descuento=descuento;
        this.fechaLanzamiento=fechaLanzamiento;
        this.imagen=imagen;
        this.artista=new Artista(idArtista);
        this.disquera=new Disquera(idDisquera);
        this.generoMusical=new GeneroMusical(idGeneroMusical);


    }
}
