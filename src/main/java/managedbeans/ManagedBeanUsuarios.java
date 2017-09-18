/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.NivelAcceso;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import sessionbeans.UsuarioFacadeLocal;
import entities.Usuario;
import static entities.Usuario_.nivelAcceso;
import java.util.List;
import sessionbeans.NivelAccesoFacadeLocal;

@Named(value = "managedBeanUsuarios")
@SessionScoped
public class ManagedBeanUsuarios implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private Usuario u = new Usuario();

    private List<Usuario> filteredUsu;
    private List<NivelAcceso> selectNivelAcceso;
    private short permiso;
    private String descripcion;

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

    public short getPermiso() {
        return permiso;
    }

    public void setPermiso(short permiso) {
        this.permiso = permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String add() {
        NivelAcceso na = new NivelAcceso(permiso, "");
        this.u.setNivelAcceso(na);
        this.usuarioFacade.create(this.u);
        this.u = new Usuario();
        return "usuario";
    }

    public void delete(Usuario u) {
        this.usuarioFacade.remove(u);
        this.usuarioFacade.findAll();
    }

    public String edit(Usuario u) {
        this.u = u;
        return "edit";
    }

    public String edit() {
        NivelAcceso na = new NivelAcceso(permiso, "");
        this.u.setNivelAcceso(na);
        this.usuarioFacade.edit(this.u);
        this.usuarioFacade.findAll();
        this.u = new Usuario();
        return "usuario";
    }
}
