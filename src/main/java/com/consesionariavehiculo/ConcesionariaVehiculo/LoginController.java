/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;


import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.Hash;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Alerta;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.AlertaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class LoginController {
    private Usuario u=null;
    @Autowired
    private UsuarioDAO us;
    @Autowired
    private AlertaDAO alerta;
    
    @PostMapping(value = "/validarUser")
    public ModelAndView validarUsuario (@ModelAttribute Usuario user, HttpSession session,Model model) {
        
    //  System.out.println(user.getNomusuario()+user.getPassusuario());
    // Encriptamos la contraseña que nos viene del login
      String sha1User= Hash.sha1(user.getPassusuario());
      // Verificamos que exista el usuario con ese nombre de usuario y contraseña encriptada
      u=us.findBynomusuarioAndPassusuario(user.getNomusuario(), sha1User);
      //System.out.println(u.getIdusuario()+u.getNomusuario()+u.getPassusuario());
      
      if(u!=null){
		session.setAttribute("usuario", u);
	//	sesionOk.setAttribute("Usuario", u);
             
               int numalertas=alerta.countByidusuarioAndActivo(u,1);
               String mensaje="Tiene alertas.Ver Bandeja de Alertas!";
      // Es una vista
              
              return new ModelAndView("plantilla/header2").addObject("numalertas",numalertas).addObject("mensajeA",mensaje).addObject("usuario",u);
 
	 }
	 else{
		 
		 model.addAttribute("error","Contraseña o Usuario inválidos");
		 return new ModelAndView("login");
          
	 }
	
  
    }
    
    @RequestMapping("/logout")
	public ModelAndView cerrarsesion(HttpSession session) {
                session.invalidate();
		return new ModelAndView("index");
	}
}
