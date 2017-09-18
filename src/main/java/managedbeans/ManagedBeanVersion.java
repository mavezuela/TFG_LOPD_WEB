/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Version;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import sessionbeans.VersionFacadeLocal;

@Named(value = "managedBeanVersion")
@SessionScoped
public class ManagedBeanVersion implements Serializable{

    @EJB
    private VersionFacadeLocal versionFacade;

    private Version v = new Version();

    private List<Version> filteredVer;
    
    private int idversion;
    private String version;
    private List<Version> listaVersion;
    private List<SelectItem> itemsVersion;


    public ManagedBeanVersion() {
    }

    public Version getV() {
        return v;
    }

    public void setV(Version v) {
        this.v = v;
    }

    public List<Version> getFilteredVer() {
        return filteredVer;
    }

    public void setFilteredVer(List<Version> filteredVer) {
        this.filteredVer = filteredVer;
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

    public List<Version> getListaVersion() {
        return listaVersion;
    }

    public void setListaVersion(List<Version> listaVersion) {
        this.listaVersion = listaVersion;
    }

    public List<SelectItem> getItemsVersion() {
        return itemsVersion;
    }

    public void setItemsVersion(List<SelectItem> itemsVersion) {
        this.itemsVersion = itemsVersion;
    }

    public List<Version> findAll() {
        return this.versionFacade.findAll();
    }

    public String add() {
        this.versionFacade.create(this.v);
        this.v = new Version();
        return "version";
    }

    public void delete(Version v) {
        this.versionFacade.remove(v);
        this.versionFacade.findAll();
    }

    public String edit(Version v) {

        this.v = v;
        return "edit";
    }

    public String edit() {
        this.versionFacade.edit(this.v);
        this.versionFacade.findAll();
        this.v = new Version();
        return "version";
    }

    public List<SelectItem> seleccionarItem() {
        listaVersion = versionFacade.findAll();

        this.itemsVersion = new ArrayList<SelectItem>();
        for (int i = 0; i <= listaVersion.size() - 1; i++) {
            SelectItem nivelVersion = new SelectItem(listaVersion.get(i).getIdversion(),listaVersion.get(i).getVersion());
            this.itemsVersion.add(nivelVersion);
        }
        return itemsVersion;
    }
    
}
