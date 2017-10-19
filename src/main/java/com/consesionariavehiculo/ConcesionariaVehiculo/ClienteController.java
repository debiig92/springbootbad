/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Cliente;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ClienteDAO;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Humberto
 */
@Controller
public class ClienteController {
     General nomUsuario= new General();
     @Autowired
      private ClienteDAO clientedao;
    @RequestMapping("/registrarCliente")
	public ModelAndView crearCliente(HttpSession session) {
         Usuario u = nomUsuario.obtenerUsuario(session);      
       return new ModelAndView("/venta/registroCliente").addObject("usuario",u);
	}
        
        
        
    @RequestMapping(value="/cliente/add", method=RequestMethod.POST)
    public ModelAndView crearCliente(@Valid Cliente cliente,BindingResult result,HttpSession session) {
         Usuario u = nomUsuario.obtenerUsuario(session);
        
        ModelAndView modelandview= new ModelAndView("/venta/registroCliente");
        clientedao.save(cliente);
        
        String mensaje="CLiente Creado!!!";
        return modelandview.addObject("usuario",u).addObject("mensaje",mensaje);    
        
    }
}
