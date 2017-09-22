/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Departamento;
import entities.Entidad;
import entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import sessionbeans.DepartamentoFacadeLocal;

@Named(value = "managedBeanDepartamento")
@SessionScoped
public class ManagedBeanDepartamento implements Serializable {

    @EJB
    private DepartamentoFacadeLocal departamentoFacade;

    private Departamento d = new Departamento();

    private List<Departamento> filteredDep;

    private List<Departamento> listaDepartamento;
    private List<SelectItem> itemsDepartamento;

    public List<SelectItem> getItemsDepartamento() {
        return itemsDepartamento;
    }

    public void setItemsDepartamento(List<SelectItem> itemsDepartamento) {
        this.itemsDepartamento = itemsDepartamento;
    }

    private int iddepartamento;
    private int ident;
    private String nombre;
    private String descripcion;
    
    private int iddepactual;

    public ManagedBeanDepartamento() {
    }

    public List<Departamento> getFilteredDep() {
        return filteredDep;
    }

    public void setFilteredDep(List<Departamento> filteredDep) {
        this.filteredDep = filteredDep;
    }

    public List<Departamento> findAll() {
        return this.departamentoFacade.findAll();
    }

    public Departamento getD() {
        return d;
    }

    public void setD(Departamento d) {
        this.d = d;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
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

    public int getIddepactual() {
        return iddepactual;
    }

    public void setIddepactual(int iddepactual) {
        this.iddepactual = iddepactual;
    }

    public String add() {
        Entidad ent = new Entidad(ident);
        this.d.setIdentidad(ent);
        this.departamentoFacade.create(this.d);
        this.d = new Departamento();
        return "departamento";
    }

    public String addgest() {
        Entidad ent = new Entidad(ident);
        this.d.setIdentidad(ent);
        this.departamentoFacade.create(this.d);
        this.d = new Departamento();
        return "departamentogest";
    }

    public void delete(Departamento d) {
        this.departamentoFacade.remove(d);
        this.departamentoFacade.findAll();
    }

    public String edit(Departamento d) {
        this.d = d;
        return "edit";
    }

    public String editgest(Departamento d) {
        this.d = d;
        return "edit";
    }

    public String edit() {
        Entidad ent = new Entidad(ident);
        this.d.setIdentidad(ent);
        this.departamentoFacade.edit(this.d);
        this.departamentoFacade.findAll();
        this.d = new Departamento();
        return "departamento";
    }

    public String editgest() {
        Entidad ent = new Entidad(ident);
        this.d.setIdentidad(ent);
        this.departamentoFacade.edit(this.d);
        this.departamentoFacade.findAll();
        this.d = new Departamento();
        return "departamentogest";
    }

    public List<SelectItem> seleccionarItem() {
        listaDepartamento = departamentoFacade.findAll();

        this.itemsDepartamento = new ArrayList<SelectItem>();
        for (int i = 0; i <= listaDepartamento.size() - 1; i++) {
            SelectItem departamentoItem = new SelectItem(listaDepartamento.get(i).getIddepartamento(), listaDepartamento.get(i).getDescripcion());
            this.itemsDepartamento.add(departamentoItem);
        }
        return itemsDepartamento;
    }

    public List<Departamento> departamentos(int identidad) {
        Entidad en = new Entidad(identidad);
        List<Departamento> dep = departamentoFacade.findByIdentidad(en);
        return dep;
    }
    
    public String irFicheros(Departamento de){
        iddepactual = de.getIddepartamento();
        return "ficheros";
    }
}
