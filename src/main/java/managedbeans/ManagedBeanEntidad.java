/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Entidad;
import entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import sessionbeans.EntidadFacadeLocal;

@Named(value = "managedBeanEntidad")
@SessionScoped
public class ManagedBeanEntidad implements Serializable {

    @EJB
    private EntidadFacadeLocal entidadFacade;
 
    private Entidad e = new Entidad();

    private List<Entidad> filteredEnt;
    
    private List<Entidad> listaEntidad;
    private List<SelectItem> itemsEntidad;
    
    private int identidad;
    private String nombre;
    private String descripcion;

    public ManagedBeanEntidad() {
    }

    public List<Entidad> getFilteredEnt() {
        return filteredEnt;
    }

    public void setFilteredEnt(List<Entidad> filteredEnt) {
        this.filteredEnt = filteredEnt;
    }

    public List<Entidad> getListaEntidad() {
        return listaEntidad;
    }

    public void setListaEntidad(List<Entidad> listaEntidad) {
        this.listaEntidad = listaEntidad;
    }

    public List<SelectItem> getItemsEntidad() {
        return itemsEntidad;
    }

    public void setItemsEntidad(List<SelectItem> itemsEntidad) {
        this.itemsEntidad = itemsEntidad;
    }

    public int getIdentidad() {
        return identidad;
    }

    public void setIdentidad(int identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Entidad getE() {
        return e;
    }

    public void setE(Entidad e) {
        this.e = e;
    }

    public List<Entidad> findAll() {
        return this.entidadFacade.findAll();
    }

    public String add() {
        this.entidadFacade.create(this.e);
        this.e = new Entidad();
        return "entidad";
    }

    public void delete(Entidad e) {
        this.entidadFacade.remove(e);
        this.entidadFacade.findAll();
    }

    public String edit(Entidad e) {

        this.e = e;
        return "edit";
    }

    public String edit() {
        this.entidadFacade.edit(this.e);
        this.entidadFacade.findAll();
        this.e = new Entidad();
        return "entidad";
    }
    
    public List<SelectItem> seleccionarItem() {
        listaEntidad = entidadFacade.findAll();

        this.itemsEntidad = new ArrayList<SelectItem>();
        for (int i = 0; i <= listaEntidad.size() - 1; i++) {
            SelectItem entidadItem = new SelectItem(listaEntidad.get(i).getIdentidad(),listaEntidad.get(i).getDescripcion());
            this.itemsEntidad.add(entidadItem);
        }
        return itemsEntidad;
    }
}
