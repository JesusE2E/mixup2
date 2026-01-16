package unam.diplomado.mixup.registrarusuario.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Data
public class Notificacion implements Serializable {
    private Integer id;
    private LocalDateTime fechaNotificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_notificacion")
    private TipoNotificacion tipoNotificacion;




}
