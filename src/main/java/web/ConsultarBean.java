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
import logica.OperCita;

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
    private String mensaje;
    
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
    
    public String getMensaje(){
        return this.mensaje;
    }
    
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    public void buscar(){
        OperCita op = new OperCita();
        this.listaCitas = null;
        this.listaCitas = op.consultar(this.documento);
        if(this.listaCitas != null){
            this.mensaje = "Se consultaron las citas del paciente con doumento: "+this.documento;
        }else{
            this.mensaje= "No se encontraron citas del paciente con documento: "+this.documento;
        }
    }
}
