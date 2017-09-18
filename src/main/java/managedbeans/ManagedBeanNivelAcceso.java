/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.NivelAcceso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import sessionbeans.NivelAccesoFacadeLocal;

@Named(value = "managedBeanNivelAcceso")
@SessionScoped
public class ManagedBeanNivelAcceso implements Serializable {

    @EJB
    private NivelAccesoFacadeLocal nivelAccesoFacade;

    private int codigo;
    private String descripcion;
    private List<NivelAcceso> listaAcceso;
    private List<SelectItem> itemsAcceso;

    public ManagedBeanNivelAcceso() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<NivelAcceso> getListaAcceso() {
        return listaAcceso;
    }

    public void setListaAcceso(List<NivelAcceso> listaAcceso) {
        this.listaAcceso = listaAcceso;
    }

    public List<SelectItem> getItemsAcceso() {
        return itemsAcceso;
    }

    public void setItemsAcceso(List<SelectItem> itemsAcceso) {
        this.itemsAcceso = itemsAcceso;
    }

    public List<SelectItem> seleccionarItem() {
        listaAcceso = nivelAccesoFacade.findAll();

        this.itemsAcceso = new ArrayList<SelectItem>();
        for (int i = 0; i <= listaAcceso.size() - 1; i++) {
            SelectItem nivelItem = new SelectItem(listaAcceso.get(i).getCodigo(),listaAcceso.get(i).getDescripcion());
            this.itemsAcceso.add(nivelItem);
        }
        return itemsAcceso;
    }
}
