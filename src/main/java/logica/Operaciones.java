/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;

/**
 *
 * @author Vinni

 * @param <T>
 */
public interface Operaciones<T> {
    public int insertar(T dato);
    public List<T> consultar(String documento);
    public int eliminar(Long id);
    public int actualizar(T dato);
}
