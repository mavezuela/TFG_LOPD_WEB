/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Ficheros;
import entities.Version;
import entities.Versionfichero;
import entities.VersionficheroPK;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import sessionbeans.VersionficheroFacadeLocal;

@Named(value = "managedBeanVersionFichero")
@SessionScoped
public class ManagedBeanVersionFichero implements Serializable {

    @EJB
    private VersionficheroFacadeLocal versionficheroFacade;

    private Versionfichero vf = new Versionfichero();

    private List<Versionfichero> filteredVerFic;
    private int idver;
    private int idfic;
    private String version;
    private String descripcion;

    public ManagedBeanVersionFichero() {
    }

    public Versionfichero getVf() {
        return vf;
    }

    public void setVf(Versionfichero vf) {
        this.vf = vf;
    }

    public List<Versionfichero> getFilteredVerFic() {
        return filteredVerFic;
    }

    public void setFilteredVerFic(List<Versionfichero> filteredVerFic) {
        this.filteredVerFic = filteredVerFic;
    }

    public int getIdver() {
        return idver;
    }

    public void setIdver(int idver) {
        this.idver = idver;
    }

    public int getIdfic() {
        return idfic;
    }

    public void setIdfic(int idfic) {
        this.idfic = idfic;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Versionfichero> findAll() {
        return this.versionficheroFacade.findAll();
    }

    public String add() {
        VersionficheroPK versPK = new VersionficheroPK(idfic, idver);

        Ficheros fic = new Ficheros(idfic);
        this.vf.setFicheros(fic);
        
        Version vers = new Version(idver);
        this.vf.setVersion1(vers);
        this.vf.setVersionficheroPK(versPK);
        
        this.versionficheroFacade.create(this.vf);

        this.vf = new Versionfichero();
        return "versionfichero";
    }

    public void delete(Versionfichero vf) {
        this.versionficheroFacade.remove(vf);
        this.versionficheroFacade.findAll();
    }

    public String edit(Versionfichero vf) {
        this.vf = vf;
        return "edit";
    }

    public String edit() {
        VersionficheroPK versPK = new VersionficheroPK(idfic, idver);

        Ficheros fic = new Ficheros(idfic);
        this.vf.setFicheros(fic);
        
        Version vers = new Version(idver);
        this.vf.setVersion1(vers);
        this.vf.setVersionficheroPK(versPK);
        
        
        this.versionficheroFacade.edit(this.vf);
        this.versionficheroFacade.findAll();
        this.vf = new Versionfichero();
        return "versionfichero";
    }
    
}
