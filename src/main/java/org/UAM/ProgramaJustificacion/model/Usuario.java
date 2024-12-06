package org.UAM.ProgramaJustificacion.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NamedQuery(name = "Usuario.findUsuario", query = "SELECT u FROM Usuario u WHERE u.cif = ?1 AND u.password = ?2")
@Table(name = "usuario")
public class Usuario extends Identifiable {
    @Column(length = 50, unique = true, nullable = false)
    private String cif;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 20)
    private String rol;
}
