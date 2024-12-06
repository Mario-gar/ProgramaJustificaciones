package org.UAM.ProgramaJustificacion.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.openxava.model.Identifiable;

import java.util.List;

@Getter
@Setter
@Entity
public class ValidacionJustificacion extends Identifiable {
    @OneToMany(mappedBy = "validacion", cascade = CascadeType.ALL)
    private List<Justificacion> justificaciones;

    public void validarJustificacion(Justificacion justificacion) {
        if (justificacion.getMotivo() != null && justificacion.getDocumento() != null) {
            justificacion.setEstado(EstadoJustificacion.ACEPTADA);
        } else {
            justificacion.setEstado(EstadoJustificacion.RECHAZADA);
        }
    }
}
