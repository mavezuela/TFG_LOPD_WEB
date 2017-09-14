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
import sessionbeans.FicherosFacadeLocal;

@Named(value = "managedBeanFicheros")
@SessionScoped
public class ManagedBeanFicheros implements Serializable{

    @EJB
    private FicherosFacadeLocal ficherosFacade;
    
    private int idfichero;
    private String nombre;
    private String descripcion;


    public ManagedBeanFicheros() {
    }

    public int getIdfichero() {
        return idfichero;
    }

    public void setIdfichero(int idfichero) {
        this.idfichero = idfichero;
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
