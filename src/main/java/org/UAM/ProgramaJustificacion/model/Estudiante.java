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
    @OneToOne
    private Usuario usuario; // Asocia al Usuario

    @Column(length = 50, nullable = false)
    private String nombre;

    @ManyToOne
    @DescriptionsList
    private Carrera carrera;

    @Column(length = 50, unique = true, nullable = false)
    private String cif; // Asegúrate de que esto sea único y no nulo
}
