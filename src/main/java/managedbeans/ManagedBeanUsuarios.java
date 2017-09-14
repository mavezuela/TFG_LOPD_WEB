/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import sessionbeans.UsuarioFacadeLocal;
import entities.Usuario;
import java.util.List;

@Named(value = "managedBeanUsuarios")
@SessionScoped
public class ManagedBeanUsuarios  implements Serializable{

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private Usuario u = new Usuario();

    private List<Usuario> filteredUsu;
    
    public ManagedBeanUsuarios() {
    }

    public List<Usuario> getFilteredUsu() {
        return filteredUsu;
    }

    public void setFilteredUsu(List<Usuario> filteredUsu) {
        this.filteredUsu = filteredUsu;
    }
    
    public List<Usuario> findAll() {
        return this.usuarioFacade.findAll();
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
    
    public String add(){
        this.usuarioFacade.create(this.u);
        this.u = new Usuario();
        return "usuario";
    }
    
    public void delete(Usuario u) {
        this.usuarioFacade.remove(u);
    }
}
