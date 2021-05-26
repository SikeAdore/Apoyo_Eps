/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dato.Cita;
import dato.Paciente;
import java.util.List;
import logica.OperCita;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alejandro
 */
public class OperCitaTest {
    
    /**
     * Test of insertar method, of class OperCita.
     */
    @Test
    public void testInsertarNull() {
        Cita dato = null;
        OperCita instance = new OperCita();
        int expResult = 0;
        int result = instance.insertar(dato);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testInsertarCitaPacienteNull() {
        Paciente p = null;
        Cita dato = new Cita(p, "12/24/28", "10:00", "Medicina General", "Si");
        OperCita instance = new OperCita();
        int expResult = 0;
        int result = instance.insertar(dato);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testInsertarCitaDatosVacios() {
        Paciente p = new Paciente("", "");
        Cita dato = new Cita(p, "", "", "", "");
        OperCita instance = new OperCita();
        int expResult = 0;
        int result = instance.insertar(dato);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of consultar method, of class OperCita.
     */
    @Test
    public void testConsultarDocuemtnoNull() {
        String documento = null;
        OperCita instance = new OperCita();
        int expResult = 0;
        List<Cita> result = instance.consultar(documento);
        assertEquals(expResult, result.size());
    }
    
     @Test
    public void testConsultarDocuemtnoVacio() {
        String documento = "";
        OperCita instance = new OperCita();
        int expResult = 0;
        List<Cita> result = instance.consultar(documento);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of eliminar method, of class OperCita.
     */
    @Test
    public void testEliminarIdNull() {
        Long id = null;
        OperCita instance = new OperCita();
        int expResult = 0;
        int result = instance.eliminar(id);
        assertEquals(expResult, result);

    }
    
    
}
