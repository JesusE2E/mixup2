package unam.diplomado.mixup.registrarusuario.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String calle;
    @Column(name="num_exterior")
    private Integer numExterior;
    @Column(name="num_interior")
    private Integer numInterior;
    @ManyToOne(targetEntity = Colonia.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colonia",nullable = false)
    private Colonia colonia;
    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;
    @ManyToOne(targetEntity = TipoDomicilio.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_domicilio" ,nullable = false)
    private TipoDomicilio tipoDomicilio;


public Domicilio(String calle,Integer numExterior,Integer numInterior,Integer idColonia,Integer idTipoDomicilio){
this.calle=calle;
this.numExterior=numExterior;
this.numInterior=numInterior;
this.colonia=new Colonia();
this.colonia.setId(idColonia);
    this.tipoDomicilio=new TipoDomicilio();
    this.tipoDomicilio.setId(idTipoDomicilio);
}




}
