package org.UAM.ProgramaJustificacion.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Facultad extends Identifiable {
    @Column(length = 100, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL)
    private List<Carrera> carreras;
}
