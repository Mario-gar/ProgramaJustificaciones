package org.UAM.ProgramaJustificacion.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

@Getter
@Setter
@Entity
@Table(name = "Estudiante")
public class Estudiante extends Identifiable {

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 20, unique = true, nullable = false)
    private String matricula;

    @ManyToOne
    @DescriptionsList
    private Carrera carrera;

}