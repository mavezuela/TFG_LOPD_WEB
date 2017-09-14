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
import sessionbeans.PreguntasversionFacadeLocal;

@Named(value = "managedBeanPreguntasversion")
@SessionScoped
public class ManagedBeanPreguntasversion implements Serializable{

    @EJB
    private PreguntasversionFacadeLocal preguntasversionFacade;
    
    private int idpreguntas;
    private String pregunta;


    public ManagedBeanPreguntasversion() {
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
    
}
