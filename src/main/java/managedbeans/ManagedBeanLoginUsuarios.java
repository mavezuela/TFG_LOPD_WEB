/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sessionbeans.UsuarioFacadeLocal;

@Named(value = "managedBeanLoginUsuarios")
@SessionScoped
public class ManagedBeanLoginUsuarios implements Serializable{

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    /**
     * Creates a new instance of ManagedBeanUsuarios
     */
    private String username;
    private String password;
    private String nivelacceso;
    private boolean loggedIn;

    public ManagedBeanLoginUsuarios() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNivelacceso() {
        return nivelacceso;
    }

    public void setNivelacceso(String nivelacceso) {
        this.nivelacceso = nivelacceso;
    }

    public String loginUsuario() {

        try {
            Usuario u = usuarioFacade.findByName(this.username);
            if (u.getPassword().equals(this.password)) {
                loggedIn = true;
                nivelacceso = u.getNivelAcceso().getCodigo().toString();
                if (nivelacceso.equals("1")) {
                    return "Administrador";
                } else {
                    if (nivelacceso.equals("2")) {
                        return "Operador";
                    } else {
                        if (nivelacceso.equals("3")) {
                            return "Consultor";
                        } else {
                            loggedIn = false;
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
                            return "ko";
                        }
                    }
                }
            } else {
                loggedIn = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
                return "ko";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public String logoutUsuario() {
        loggedIn = false;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
        return "Salir";

    }
}
