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
import sessionbeans.VersionficheroFacadeLocal;

@Named(value = "managedBeanVersionFichero")
@SessionScoped
public class ManagedBeanVersionFichero implements Serializable{

    @EJB
    private VersionficheroFacadeLocal versionficheroFacade;
    
    private String version;
    private String descripcion;


    public ManagedBeanVersionFichero() {
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
    
}
