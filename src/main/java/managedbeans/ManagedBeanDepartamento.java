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
import sessionbeans.DepartamentoFacadeLocal;

@Named(value = "managedBeanDepartamento")
@SessionScoped
public class ManagedBeanDepartamento implements Serializable{

    @EJB
    private DepartamentoFacadeLocal departamentoFacade;
    
    private int iddepartamento;
    private String nombre;
    private String descripcion;


    public ManagedBeanDepartamento() {
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
