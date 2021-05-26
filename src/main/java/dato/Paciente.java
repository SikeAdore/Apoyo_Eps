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
public class Paciente {
    private String nombre;
    private String documento;

    public Paciente(){
        
    }
    public Paciente(String nombre, String documento){
        this.nombre = nombre;
        this.documento = documento;
    }
    
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
    
}
