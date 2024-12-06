package org.UAM.ProgramaJustificacion.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Carrera extends Identifiable {
	private String nombre;

	@ManyToOne
	private Facultad facultad;

	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<Clase> clases;

	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<Estudiante> estudiante;
}
