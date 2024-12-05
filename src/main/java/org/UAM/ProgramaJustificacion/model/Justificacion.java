package org.UAM.ProgramaJustificacion.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import java.time.LocalDate;

@View(members =
        "estudiante;" +
                "clase;" +
                "fechas;" +
                "motivo;" +
                "documento;" +
                "estado;"
)

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
    private LocalDate fechaInicio; // Fecha de inicio del rango

    @Stereotype("DATE")
    private LocalDate fechaFin; // Fecha final del rango

    @Column(length = 500)
    private String motivo;

    @Stereotype("FILE")
    private byte[] documento;

    @Enumerated(EnumType.STRING)
    private EstadoJustificacion estado = EstadoJustificacion.PENDIENTE;
}

