/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.main;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.Hash;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rol;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ClienteDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.RolRepo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.UsuarioRepo;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
public class UsuarioController {
    General nomUsuario= new General();
    @Autowired
    private UsuarioRepo userrepo;
    
    @Autowired
    private RolRepo rolesrepo;
    
    
    
    @RequestMapping("/usuarioadd")
    public ModelAndView usuario(HttpSession session){
     Usuario u = nomUsuario.obtenerUsuario(session);   
     List<Rol> listaRol= (List<Rol>) rolesrepo.findAll();
    return new ModelAndView("/usuarioadd").addObject("usuario",u).addObject("roles",listaRol);
    }
    
    @RequestMapping(value="/usuario/user",method=RequestMethod.POST)
       public ModelAndView crearuser(@Valid Usuario usuario, BindingResult bindingResult,HttpSession session){
       Usuario u = nomUsuario.obtenerUsuario(session);   
       String mensaje="";
       String sha1User= Hash.sha1(usuario.getPassusuario());
       usuario.setPassusuario(sha1User);
        //ModelAndView modelandview= new ModelAndView("/usuarioadd");
           long acumulador=0;
        if(userrepo.count()==0){
        usuario.setIdusuario(1);
        }
        else{
            acumulador=userrepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
             usuario.setIdusuario(valor+1);}
             ModelAndView modelandview= new ModelAndView("/usuarioadd");
             //userService.saveUser(user,rol);
             userrepo.save(usuario);
             //userService.saveUser(user,rol);
             mensaje="Usuario Creado!!!";
        
              return modelandview.addObject("usuario",u).addObject("mensaje",mensaje);               
        // return "redirect:/login";
        }
    
       
        @RequestMapping("/usuarioindex")
	public ModelAndView ListUsuario(HttpSession session){
                 Usuario u = nomUsuario.obtenerUsuario(session);
                 ModelAndView modelandview= new ModelAndView("/usuarioindex");
		 List<Usuario> list=(List<Usuario>) userrepo.findAll();
               return modelandview.addObject("usuario",u).addObject("userList",list);
		//return new ModelAndView("usuarioindex","userList",list);
    }
    
    
}
