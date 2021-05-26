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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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
        if(this.documento != null && !" ".equals(this.documento)){
            this.listaCitas = op.consultar(this.documento);
            if (this.listaCitas.size() > 0 && this.listaCitas != null) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se consultaron las citas del paciente con documento: "+this.documento));
            } else {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "No se encontraron citas agendadas para el paciente con documento: "+this.documento));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se requiere el documento del paciente para realizar la consulta "));
        }
        
    }
    
    public void eliminar(){
        OperCita op = new OperCita();
        if(this.documento != null && !" ".equals(this.documento)){
            if(this.citaSeleccionada != null){
                if(op.eliminar(this.citaSeleccionada.getId())>0){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se eliminó la cita con exito "));
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente al eliminar, intente mas tarde "));
                }
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Seleccione una cita para eliminarla"));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Realize la consulta de las citas de un paciente primero"));
        }
        
    }
}
