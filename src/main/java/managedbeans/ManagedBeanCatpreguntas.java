/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Catpreguntas;
import entities.Catpregversion;
import entities.Ficheros;
import entities.Preguntas;
import entities.Preguntasversion;
import entities.Version;
import entities.Versionfichero;
import entities.VersionficheroPK;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sessionbeans.CatpreguntasFacadeLocal;
import sessionbeans.CatpregversionFacade;
import sessionbeans.CatpregversionFacadeLocal;
import sessionbeans.PreguntasFacadeLocal;
import sessionbeans.PreguntasversionFacade;
import sessionbeans.PreguntasversionFacadeLocal;

@Named(value = "managedBeanCatpreguntas")
@SessionScoped
public class ManagedBeanCatpreguntas implements Serializable {

    @EJB
    private PreguntasversionFacadeLocal preguntasversionFacade;

    @EJB
    private PreguntasFacadeLocal preguntasFacade;

    @EJB
    private CatpregversionFacadeLocal catpregversionFacade;

    @EJB
    private CatpreguntasFacadeLocal catpreguntasFacade;

    private int idcatpreguntas;
    private String categoria;
    private String descripcion;
    private double porcentaje;
    private int cont;
    private int contpreg;

    private Catpreguntas cp = new Catpreguntas();

    private Preguntas p = new Preguntas();

    public Catpreguntas getCp() {
        return cp;
    }

    public void setCp(Catpreguntas cp) {
        this.cp = cp;
    }

    public Preguntas getP() {
        return p;
    }

    public void setP(Preguntas p) {
        this.p = p;
    }

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

    public void preparar(Versionfichero vfprep) {

        try {

            List<Catpreguntas> contador = catpreguntasFacade.findAll();
            if (contador.size() > 0) {
                cont = contador.get(contador.size() - 1).getIdcatpreguntas();
            } else {
                cont = 0;
            }

            Version ver = vfprep.getVersion1();
            List<Catpregversion> cpv = catpregversionFacade.findByIdversion(ver);

            for (int i = 0; i <= cpv.size() - 1; i++) {

                int idfic = vfprep.getFicheros().getIdfichero();
                int idver = vfprep.getVersion1().getIdversion();

                Versionfichero vf = new Versionfichero();
                Ficheros fic = new Ficheros(idfic);
                vf.setFicheros(fic);

                Version vers = new Version(idver);
                vf.setVersion1(vers);

                VersionficheroPK versPK = new VersionficheroPK(idfic, idver);

                this.cp.setIdcatpreguntas(i + 1 + cont);
                this.cp.setVersionfichero(vf);
                this.cp.getVersionfichero().setVersionficheroPK(versPK);
                this.cp.setCategoria(cpv.get(i).getCategoria());
                this.cp.setDescripción(cpv.get(i).getDescripcion());
                this.cp.setPorcentaje(BigDecimal.ZERO);
                this.catpreguntasFacade.create(this.cp);

                List<Preguntas> contpreguntas = preguntasFacade.findAll();
                if (contpreguntas.size() > 0) {
                    contpreg = contpreguntas.get(contpreguntas.size() - 1).getIdpreguntas();
                } else {
                    contpreg = 0;
                }

                Catpregversion catpregver = new Catpregversion(cpv.get(i).getIdcatpreguntas());
                List<Preguntasversion> pv = preguntasversionFacade.findByIdcatpregversion(catpregver);
                for (int j = 0; j <= pv.size() - 1; j++) {

                    Catpreguntas catpreguntas = new Catpreguntas();
                    catpreguntas.setIdcatpreguntas(cp.getIdcatpreguntas());

                    this.p.setIdpreguntas(j + 1 + contpreg);
                    this.p.setIdcatpreguntas(catpreguntas);
                    this.p.setPregunta(pv.get(j).getPregunta());
                    this.p.setPorcentaje(BigDecimal.ZERO);
                    this.p.setCumplimiento(BigDecimal.ZERO);
                    this.preguntasFacade.create(this.p);
                    this.p = new Preguntas();
                }

                this.cp = new Catpreguntas();

            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Fichero Preparado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Error en Preparación"));
        }
    }

}
