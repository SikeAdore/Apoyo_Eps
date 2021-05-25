/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dato.Cita;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alejandro
 */
@ManagedBean
@SessionScoped
public class ConsultarBean implements Serializable{

    private Cita citaSeleccionada;
    private String documento;
    private List<Cita> listaCitas;
    
    public Cita getCitaSeleccionada() {
        return citaSeleccionada;
    }

    public void setCitaSeleccionada(Cita citaSeleccionada) {
        this.citaSeleccionada = citaSeleccionada;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }
    
    public void consultar(){
        
    }
}
