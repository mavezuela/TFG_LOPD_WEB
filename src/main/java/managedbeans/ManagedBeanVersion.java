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
import sessionbeans.VersionFacadeLocal;

@Named(value = "managedBeanVersion")
@SessionScoped
public class ManagedBeanVersion implements Serializable{

    @EJB
    private VersionFacadeLocal versionFacade;
    
    private int idversion;
    private String version;


    public ManagedBeanVersion() {
    }

    public int getIdversion() {
        return idversion;
    }

    public void setIdversion(int idversion) {
        this.idversion = idversion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
}
