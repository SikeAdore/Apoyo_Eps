/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alejandro
 */
@ManagedBean
@SessionScoped
public class InicioBean implements Serializable {
    public String ingresar(){
        return "citas";
    }
}
