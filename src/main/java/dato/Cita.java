/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dato;





/**
 *
 * @author alejandro
 */
public class Cita {

    private Long id;
    private Paciente paciente;
    private String fecha;
    private String hora;
    private String tipoCita;
    private String pertenece;

    private Integer costo;
    
    public String getPertenece() {
        return pertenece;
    }

    public void setPertenece(String pertenece) {
        this.pertenece = pertenece;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
    
     public Integer getCosto() {
        return costo;
    }

    public void setCosto() {
        if("No".equals(this.pertenece)){
            this.costo = 15000;
        }else if("Si".equals(this.pertenece)){
            this.costo = 0;
        }
    }

    public void setCosto(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}