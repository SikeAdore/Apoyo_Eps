/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dato.Cita;
import dato.Paciente;
import java.io.Serializable;
import java.util.Date;
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
public class AgendarBean implements Serializable{

    private Long id;
    private String nombre;
    private String documento;
    private Date fecha;
    private String hora;
    private String tipoCita;
    private String pertenece;
    private String mensaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }
    
    public String getPertenece() {
        return pertenece;
    }

    public void setPertenece(String pertenece) {
        this.pertenece = pertenece;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String guardar(){
        Cita c = new Cita();
        Paciente p = new Paciente();
        if(this.nombre != null && this.documento != null && this.fecha != null && this.hora != null && this.pertenece != null && this.tipoCita != null){

            Date fechaA = new Date();
            if(this.fecha.before(fechaA)|| this.fecha.equals(fechaA)){
                this.mensaje = "Error, Selecciones una fecha valida";
                return "agendar";
            }else{
                p.setNombre(this.nombre);
                p.setDocumento(this.documento);
                c.setPaciente(p);
                c.setFecha(this.fecha.toString());
                c.setHora(this.hora);
                c.setTipoCita(this.tipoCita);
                c.setPertenece(this.pertenece);
                c.setCosto();
                this.mensaje = "Se almacenó";
                OperCita op = new OperCita();
                if (op.insertar(c) > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se agendó la cita exitosamente"));
                    return "inicio";
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
                    return "agendar";
                }
            }
        }else{
            this.mensaje = "Error, llene los campos de información e intente de nuevo ";
            return "agendar";
        }
        
    }
    
    public String volver(){
        return "inicio";
    }

   
    
}
