/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import sessionbeans.UsuarioFacadeLocal;

/**
 *
 * @author usuario
 */
@Named(value = "managedBeanUsuario")
@SessionScoped
public class ManagedBeanUsuario implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    /**
     * Creates a new instance of ManagedBeanUsuario
     */
    private String username;
    private String password;

    private List<Usuario> listaUsuarios;

    public ManagedBeanUsuario() {

    }

    public String loginUsuario() {

        Usuario u = usuarioFacade.findByName(username);
        if (u.getPassword().equals(password)) {
            return "ok";
        } else {
            return "ko";
        }
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

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
