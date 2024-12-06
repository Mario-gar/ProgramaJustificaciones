package org.UAM.ProgramaJustificacion.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;
import java.util.List;

@Getter
@Setter
@Entity
@View(members = "justificaciones { justificacion };")
@Tab(properties = "justificaciones.estudiante.nombre, justificaciones.clase.nombre, justificaciones.fechaInicio, justificaciones.fechaFin, justificaciones.estado")
public class ValidacionJustificacion extends Identifiable {
    @OneToMany(mappedBy = "validacion", cascade = CascadeType.ALL)
    @CollectionView("adminView")
    private List<Justificacion> justificaciones;

    @Action(value = "ValidacionJustificacion.aprobar")
    public void aprobar(Justificacion justificacion) {
        justificacion.setEstado(EstadoJustificacion.ACEPTADA);
    }

    @Action(value = "ValidacionJustificacion.rechazar")
    public void rechazar(Justificacion justificacion) {
        justificacion.setEstado(EstadoJustificacion.RECHAZADA);
    }

    @Action(value = "ValidacionJustificacion.pendiente")
    public void pendiente(Justificacion justificacion) {
        justificacion.setEstado(EstadoJustificacion.PENDIENTE);
    }
}
