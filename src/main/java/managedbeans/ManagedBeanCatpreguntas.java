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
import sessionbeans.CatpreguntasFacadeLocal;

@Named(value = "managedBeanCatpreguntas")
@SessionScoped
public class ManagedBeanCatpreguntas implements Serializable{

    @EJB
    private CatpreguntasFacadeLocal catpreguntasFacade;
    
    private int idcatpreguntas;
    private String categoria;
    private String descripcion;
    private double porcentaje;
    

    public ManagedBeanCatpreguntas() {
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

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
