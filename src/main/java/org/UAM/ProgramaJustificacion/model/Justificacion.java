package org.UAM.ProgramaJustificacion.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import java.time.LocalDate;

@View(members = "estudiante; clase; fechaInicio; fechaFin; motivo; documento; estado;")
@Views({
        @View(name = "adminView", members = "estudiante; clase; fechaInicio; fechaFin; motivo; documento; estado;"),
        @View(name = "studentView", members = "cif; nombre; clase; fechaInicio; fechaFin; motivo; documento;")
})
@Getter
@Setter
@Entity
public class Justificacion extends Identifiable {
    @ManyToOne
    @DescriptionsList
    private Estudiante estudiante;

    @ManyToOne
    @DescriptionsList
    private Clase clase;

    @Stereotype("DATE")
    private LocalDate fechaInicio;

    @Stereotype("DATE")
    private LocalDate fechaFin;

    @Column(length = 500)
    private String motivo;

    @File
    @Column(length = 32)
    private String fotos;

    @Enumerated(EnumType.STRING)
    private EstadoJustificacion estado;

    @ManyToOne
    @DescriptionsList
    private ValidacionJustificacion validacion;

    @PrePersist
    public void prePersist() {
        this.estado = EstadoJustificacion.PENDIENTE;
    }
}
