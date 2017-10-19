/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.main;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rol;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.RolDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author carlos
 */
@Controller
public class RolesController {
    @Autowired
    RolDAO rolrepo;
    General nomUsuario= new General();
    
    
    
    @RequestMapping(value="/rolnew")
    public ModelAndView rol(HttpSession session){
         Usuario u = nomUsuario.obtenerUsuario(session); 
         return new ModelAndView("/rolnew").addObject("usuario",u);
       
    }

    //cargar vista de taller 
    @RequestMapping(value="/roles/guardar", method=RequestMethod.POST)
    public ModelAndView nuevo(@Valid Rol rol, BindingResult bindingResult,HttpSession session){
        Usuario u = nomUsuario.obtenerUsuario(session);
         long acumulador=0;
        if(rolrepo.count()==0){
        rol.setIdrol(1);
        }
        else{
            acumulador=rolrepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            rol.setIdrol(valor+1);}
             ModelAndView modelandview= new ModelAndView("/rolnew");
        rolrepo.save(rol);
        String mensaje="Rol Creado!!!";
        return modelandview.addObject("usuario",u).addObject("mensaje",mensaje);  
        //return "redirect:/roles/rolindex";
    }
    
    //muestra todos los datos de los talleres
    @RequestMapping("/rolindex")
	public ModelAndView ListRol(HttpSession session){
            Usuario u = nomUsuario.obtenerUsuario(session);
            ModelAndView modelandview= new ModelAndView("/rolindex");
            List<Rol> list=(List<Rol>) rolrepo.findAll();
            return modelandview.addObject("usuario",u).addObject("rolList",list);
		//return new ModelAndView("/rolindex","rolList",list);
    }
    
}
