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
import sessionbeans.NivelAccesoFacadeLocal;

@Named(value = "managedBeanNivelAcceso")
@SessionScoped
public class ManagedBeanNivelAcceso implements Serializable{

    @EJB
    private NivelAccesoFacadeLocal nivelAccesoFacade;
    
    private int codigo;
    private String descripcion;

    public ManagedBeanNivelAcceso() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

