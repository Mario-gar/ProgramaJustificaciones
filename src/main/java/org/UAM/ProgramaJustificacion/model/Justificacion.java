package org.UAM.ProgramaJustificacion.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import java.time.LocalDate;

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
    private LocalDate fecha;

    @Stereotype("FILE")
    private byte[] documento;

    @Column(length = 20, nullable = false)
    private String estado = "Pendiente";

}