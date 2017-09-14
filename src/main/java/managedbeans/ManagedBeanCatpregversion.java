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
import sessionbeans.CatpregversionFacadeLocal;

@Named(value = "managedBeanCatpregversion")
@SessionScoped
public class ManagedBeanCatpregversion implements Serializable{

    @EJB
    private CatpregversionFacadeLocal catpregversionFacade;
    
    private int idcatpreguntas;
    private String categoria;
    private String descripcion;


    public ManagedBeanCatpregversion() {
    }

    public int getIdcatpreguntas() {
        return idcatpreguntas;
    }

    public void setIdcatpreguntas(int idcatpreguntas) {
        this.idcatpreguntas = idcatpreguntas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
