/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import database.Conexiones;
import java.sql.Connection;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author alejandro
 */
public class ConexionTest {
    @Test
    public void conexion(){
    Conexiones c = new Conexiones();
    Connection cActiva = c.conectarse();
    assertNotNull(cActiva);    
    }
    @Test
    public void desconectarse(){
        Conexiones c = new Conexiones();
        Connection cActiva= c.conectarse();
        c.desconectase(cActiva);      
        assertNotNull(c);               
    }
    @Test
    public void desconectarseNull(){
        Conexiones c = new Conexiones();
        c.desconectase(null);       
        assertNotNull(c);               
    }
}
