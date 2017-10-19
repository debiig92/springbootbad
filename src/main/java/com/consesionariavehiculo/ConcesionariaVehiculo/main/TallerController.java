/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.main;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rol;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Taller;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.TallerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

/**
 *
 * @author carlos
 */
@Controller
public class TallerController {
    
    //variables globales aqui llamaremos nuestro repositorio
    @Autowired
    private TallerRepo tallerRepo;
      General nomUsuario= new General();
    
    @RequestMapping(value="/tallernew")
    public ModelAndView taller(HttpSession session){
    Usuario u = nomUsuario.obtenerUsuario(session);   
    return new ModelAndView("/tallernew").addObject("usuario",u);
    }
    
    
    
    
    //operacion para registar taller 
    @RequestMapping(value="/taller/add", method=RequestMethod.POST)
    public ModelAndView CrearTaller(@Valid Taller taller, BindingResult bindingResult,HttpSession session){
        Usuario u = nomUsuario.obtenerUsuario(session);   
        String mensaje=""; 
        long acumulador=0;
        if(tallerRepo.count()==0){
        taller.setIdtaller(1);
        }
        else{
            acumulador=tallerRepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            taller.setIdtaller(valor+1);}
            ModelAndView modelandview= new ModelAndView("/tallernew");
            tallerRepo.save(taller);
            //direccion mientras cambiar al show de taller
            //return "redirect:/taller/"+taller.getIdtaller();
            mensaje="Usuario Creado!!!";        
            return modelandview.addObject("usuario",u).addObject("mensaje",mensaje);    
    }
    
    
    //mostrar datos de un taller show
   /* @RequestMapping("taller/show/{idtaller}")
    public String showTaller(@PathVariable Integer idtaller, Model model){
        model.addAttribute("taller",tallerRepo.findOne(idtaller));
        return "taller/show";
    }*/
    @RequestMapping(value="/tallershow/{idtaller}")
    public ModelAndView showTaller(@PathVariable Integer idtaller, Model model,HttpSession session){
        Usuario u = nomUsuario.obtenerUsuario(session);
        model.addAttribute("taller",tallerRepo.findOne(idtaller));
        ModelAndView modelandview= new ModelAndView("/tallershow");
        
        return modelandview.addObject("usuario",u);
        
    }
    
    
    
    //muestra todos los datos de los talleres
   /* @RequestMapping("/tallershow")
	public ModelAndView ListTaller(@PathVariable Integer idtaller, Model model,HttpSession session){
            Usuario u = nomUsuario.obtenerUsuario(session);
            model.addAttribute("taller",tallerRepo.findOne(idtaller));
            ModelAndView modelandview= new ModelAndView("/tallershow");
            List<Taller> list=(List<Taller>) tallerRepo.findAll();
            return modelandview.addObject("usuario",u).addObject("tallerList",list);
		//return new ModelAndView("/rolindex","rolList",list);
    }*/
    
    //carga la pagina del edit y asigna datos a su contenido
    @RequestMapping("/taller/edit/{idtaller}")
    public String tallerEdit(@PathVariable int idtaller, Model model){
        model.addAttribute("taller",tallerRepo.findOne(idtaller));
        return "taller/edit";
    }
    
    //actualizar datos en la base
    @RequestMapping(value="/taller/update", method=RequestMethod.POST)
    public String actualizar(Taller taller){
	tallerRepo.save(taller);
	return "redirect:/taller/show/"+taller.getIdtaller();
    }
    
    //muestra todos los datos de los talleres
    @RequestMapping(value="/tallerprincipal")
	public ModelAndView ListTaller(@Valid Taller taller, BindingResult bindingResult,HttpSession session){
	      
            Usuario u = nomUsuario.obtenerUsuario(session);
            ModelAndView modelandview= new ModelAndView("/tallerprincipal");
            List<Taller> list=(List<Taller>) tallerRepo.findAll();
            return modelandview.addObject("usuario",u).addObject("tallerList",list);           
                
    }
        
    
    //eliminar un taller
    @RequestMapping(value="/taller/delete/{idtaller}",method=RequestMethod.GET)
    public ModelAndView eliminar(@PathVariable Integer idtaller){
        ModelAndView modelandview= new ModelAndView("taller/show");
        tallerRepo.delete(idtaller);
        //mensaje de eliminacion falta q lo muestre en la pantalla
        String message="Taller eliminado";
        modelandview.addObject("message",message);
        return modelandview;
    
    }
    
}
