/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Catpreguntas;
import entities.Preguntas;
import java.io.Serializable;
import java.util.List;
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

    private List<Preguntas> filteredPreg;
    
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

    public List<Preguntas> getFilteredPreg() {
        return filteredPreg;
    }

    public void setFilteredPreg(List<Preguntas> filteredPreg) {
        this.filteredPreg = filteredPreg;
    }

    public List<Preguntas> findAll() {
        return this.preguntasFacade.findAll();
    }
    
    public List<Preguntas> recogerpreg(int idcatpreguntas){
        Catpreguntas cp = new Catpreguntas(idcatpreguntas);
        List<Preguntas> preg = preguntasFacade.findByIdcatpreguntas(cp);
        return preg;
    }

    
    public void edit(Preguntas p) {
        preguntasFacade.edit(p);
     }

}
