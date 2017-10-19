/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Humberto
 */
public class General {
    
    Usuario usuario=new Usuario();
     public Usuario obtenerUsuario(HttpSession session){
       
       usuario = (Usuario) session.getAttribute("usuario");
       return usuario;
       }
}
