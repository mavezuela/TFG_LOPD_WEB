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
import sessionbeans.PreguntasFacadeLocal;

@Named(value = "managedBeanPreguntas")
@SessionScoped
public class ManagedBeanPreguntas implements Serializable{

    @EJB
    private PreguntasFacadeLocal preguntasFacade;
    
    private int idpreguntas;
    private String pregunta;
    private double porcentaje;
    private double cumplimiento;


    public ManagedBeanPreguntas() {
    }

    public int getIdpreguntas() {
        return idpreguntas;
    }

    public void setIdpreguntas(int idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(double cumplimiento) {
        this.cumplimiento = cumplimiento;
    }
    
}
