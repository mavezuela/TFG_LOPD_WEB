/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Departamento;
import entities.Ficheros;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import sessionbeans.FicherosFacadeLocal;

@Named(value = "managedBeanFicheros")
@SessionScoped
public class ManagedBeanFicheros implements Serializable {

    @EJB
    private FicherosFacadeLocal ficherosFacade;

    private Ficheros f = new Ficheros();

    private List<Ficheros> filteredFic;
    private int idfichero;
    private int iddep;
    private String nombre;
    private String descripcion;
    private List<Ficheros> listaFicheros;
    private List<SelectItem> itemsFicheros;


    public ManagedBeanFicheros() {
    }

    public Ficheros getF() {
        return f;
    }

    public void setF(Ficheros f) {
        this.f = f;
    }

    public List<Ficheros> getFilteredFic() {
        return filteredFic;
    }

    public void setFilteredFic(List<Ficheros> filteredFic) {
        this.filteredFic = filteredFic;
    }

    public List<Ficheros> findAll() {
        return this.ficherosFacade.findAll();
    }

    public int getIddep() {
        return iddep;
    }

    public void setIddep(int iddep) {
        this.iddep = iddep;
    }

    public int getIdfichero() {
        return idfichero;
    }

    public void setIdfichero(int idfichero) {
        this.idfichero = idfichero;
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

    public List<Ficheros> getListaFicheros() {
        return listaFicheros;
    }

    public void setListaFicheros(List<Ficheros> listaFicheros) {
        this.listaFicheros = listaFicheros;
    }

    public List<SelectItem> getItemsFicheros() {
        return itemsFicheros;
    }

    public void setItemsFicheros(List<SelectItem> itemsFicheros) {
        this.itemsFicheros = itemsFicheros;
    }

    public String add() {
        Departamento dep = new Departamento(iddep);
        this.f.setIddepartamento(dep);
        this.ficherosFacade.create(this.f);
        this.f = new Ficheros();
        return "ficheros";
    }

    public void delete(Ficheros f) {
        this.ficherosFacade.remove(f);
        this.ficherosFacade.findAll();
    }

    public String edit(Ficheros f) {
        this.f = f;
        return "edit";
    }

    public String edit() {
        Departamento dep = new Departamento(iddep);
        this.f.setIddepartamento(dep);
        this.ficherosFacade.edit(this.f);
        this.ficherosFacade.findAll();
        this.f = new Ficheros();
        return "ficheros";
    }

        public List<SelectItem> seleccionarItem() {
        listaFicheros = ficherosFacade.findAll();

        this.itemsFicheros = new ArrayList<SelectItem>();
        for (int i = 0; i <= listaFicheros.size() - 1; i++) {
            SelectItem ficherosItem = new SelectItem(listaFicheros.get(i).getIdfichero(),listaFicheros.get(i).getNombre());
            this.itemsFicheros.add(ficherosItem);
        }
        return itemsFicheros;
    }

}
