/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
import dato.Cita;
import dato.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class OperCita implements Operaciones<Cita> {

    @Override
    public int insertar(Cita dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null && dato != null && dato.getPaciente()!= null){
            try {
                String sql = "insert into citas (nombre_p, documento_p, fecha, hora, tipo, pertenece, costo) values (?,?,?,?,?,?,?)";
                PreparedStatement ps =  cActiva.prepareStatement(sql);
                ps.setString(1, dato.getPaciente().getNombre());
                ps.setString(2,dato.getPaciente().getDocumento());
                ps.setString(3,dato.getFecha());
                ps.setString(4, dato.getHora());
                ps.setString(5, dato.getTipoCita());
                ps.setString(6, dato.getPertenece());
                ps.setInt(7, dato.getCosto());
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperCita.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                c.desconectase(cActiva);
            }
        }
        return 0;
    }

    @Override
    public List<Cita> consultar(String documento) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Cita> datos = new ArrayList();
        if (cActiva != null){
            try {
                String sql = "select * from citas where documento_p=? ";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, documento);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Cita ci = new Cita();
                    Paciente p = new Paciente();
                    p.setDocumento(rs.getString("documento_p"));
                    p.setNombre(rs.getString("nombre_p"));
                    ci.setId(rs.getLong("id"));
                    ci.setPaciente(p);
                    ci.setFecha(rs.getString("fecha"));
                    ci.setHora(rs.getString("hora"));
                    ci.setTipoCita(rs.getString("tipo"));
                    ci.setPertenece(rs.getString("pertenece"));
                    ci.setCosto(rs.getInt("costo"));
                    datos.add(ci);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperCita.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return datos;
    }

    @Override
    public int eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Cita dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}    