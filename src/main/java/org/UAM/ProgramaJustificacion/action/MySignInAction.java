package org.UAM.ProgramaJustificacion.action;


import org.UAM.ProgramaJustificacion.model.Usuario;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

public class MySignInAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        // Obtener datos de la vista
        String cif = (String) getView().getValue("user");
        String password = (String) getView().getValue("password");

        if (cif == null || cif.isEmpty() || password == null || password.isEmpty()) {
            addError("Debe ingresar su CIF y contraseña");
            return;
        }

        // Validar el usuario en la base de datos
        TypedQuery<Usuario> query = XPersistence.getManager()
                .createQuery("SELECT u FROM Usuario u WHERE u.cif = :cif AND u.password = :password", Usuario.class);
        query.setParameter("cif", cif);
        query.setParameter("password", password);

        Usuario usuario = query.getResultStream().findFirst().orElse(null);
        if (usuario == null) {
            addError("Usuario no autorizado");
            return;
        }

        // Guardar usuario en sesión
        HttpSession session = getRequest().getSession();
        session.setAttribute("currentUser", usuario);

        // Redirigir al módulo principal
        String contextPath = getRequest().getContextPath();
        HttpServletResponse response = (HttpServletResponse) getContext().getResponse();
        response.sendRedirect(contextPath + "/m/Principal"); // Cambia "Principal" por el nombre de tu módulo inicial
    }
}

