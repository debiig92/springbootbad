/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionesViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportadorDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Importaciones;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.TransactionRolledbackException;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Humberto
 */
@Controller
public class ImportacionController {
    Importador i= new Importador();
    Usuario usuario;
    //public static final DateFormat DATE_FORMAT_YYYY_MM_DD = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
 private static final org.slf4j.Logger log = LoggerFactory.getLogger(ImportacionController.class);
    @Autowired
    private ImportacionDAO imp;
    @Autowired
    private ImportadorDAO importador;
@Autowired
      private VehiculoDAO vehiculodao;
@Autowired
    private ImportacionesViewDAO vistaImportacion;
    @RequestMapping("/crearImportacion")
	public ModelAndView obtenerImportacion(HttpSession session) {
        Usuario u = obtenerUsuario(session);
        System.out.println(u.getIdusuario()+u.getNomusuario()+u.getPassusuario());
        List<Importador> importadores=(List<Importador>) importador.findAll();
      if(u.getIdrol()==3){
       i= obtenerImportadorByUsuario(u);
       System.out.println(i.getNit()+i.getNomimp());
        return new ModelAndView("importacion/nuevaImportacion").addObject("usuario",u).addObject("importador",i).addObject("importadores",importadores);
      } else{
       return new ModelAndView("importacion/nuevaImportacion").addObject("usuario",u).addObject("importadores",importadores);
      }
       
      
	}
        
    @RequestMapping(value="/importacion/add", method=RequestMethod.POST)
     
    public ModelAndView crearCliente(@Valid Importacion importacion,BindingResult result,HttpSession session) {
        Usuario u = obtenerUsuario(session);
       System.out.println(importacion.getFecimport());
        long acumulador=0;
        if(imp.count()==0){
        importacion.setIdimport(1);
        }
        else
        acumulador=imp.count();
        int valor=(int) acumulador;
        importacion.setIdimport(valor+1);
        ModelAndView modelandview= new ModelAndView("importacion/nuevaImportacion");
        imp.save(importacion);
        List<Importador> importadores=(List<Importador>) importador.findAll();
        String mensaje="Importacion Creada!!!";
        return modelandview.addObject("usuario",u).addObject("importador",i).addObject("mensaje",mensaje).addObject("importadores",importadores);   
        
    }

     @RequestMapping("/importacion/importaciones")
	public ModelAndView ListImportaciones(HttpSession session){
            Usuario u = obtenerUsuario(session);
           
          
             if(u.getIdrol()==3){
                Importador im= obtenerImportadorByUsuario(u);
                   System.out.println("------------------>"+im.getNit()+im.getNomimp());
                List<Importacion> list=imp.findBynit(im.getNit());
                 return new ModelAndView("importacion/mostrarImportaciones").addObject("usuario",u).addObject("importaciones",list);
             }
             else{
              List<Importacion> list=(List<Importacion>) imp.findAll();
               return new ModelAndView("importacion/mostrarImportaciones").addObject("usuario",u).addObject("importaciones",list);
             }
            //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
           
    }
        
        
        //carga la pagina del edit y asigna datos a su contenido
    @RequestMapping("/importacion/edit/{idimport}")
    public String importacionEdit(@PathVariable int idimport, Model model,HttpSession session){
        Usuario u = obtenerUsuario(session);
        Importacion i = imp.findOne(idimport);
        model.addAttribute("usuario",u);
        model.addAttribute("importacion",i);
        return "importacion/importacionActualizar";
    }
    
    //actualizar datos en la base
    @RequestMapping(value="/importacion/update", method=RequestMethod.POST)
    public String actualizar(@Valid Importacion importacion ,BindingResult result,HttpSession session,Model model){
       Usuario u = obtenerUsuario(session);
       String mensaje="Importacion Actualizada con Exito!!";
       if(u.getIdrol()==3){
       Importador im= obtenerImportadorByUsuario(u);
       imp.save(importacion);
       List<Importacion> list=imp.findBynit(im.getNit());
        model.addAttribute("importaciones",list);
       }
       else{
        List<Importacion> list=(List<Importacion>) imp.findAll();
        model.addAttribute("importaciones",list);
       }
      //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
       model.addAttribute("usuario",u);
      
       model.addAttribute("Exito",mensaje);
	return "/importacion/mostrarImportaciones";
    }
    
    
        
    //eliminar un taller
    @RequestMapping(value="/importacion/delete/{idimport}",method=RequestMethod.GET)
    public String eliminar(@PathVariable Integer idimport,HttpSession session, Model model){
       Usuario u = obtenerUsuario(session);
       String mensaje2="No puede borrar importacion!, posee Vehiculos";   
       String mensaje="Importacion Borrada con Exito!!";
       Importacion importa=imp.findOne(idimport);
       if(u.getIdrol()==3){
       Importador im= obtenerImportadorByUsuario(u);
    
        if(!vehiculodao.findByidimport(importa).isEmpty()){
            List<Importacion> list=imp.findBynit(im.getNit());
             //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            model.addAttribute("usuario",u);
            model.addAttribute("importaciones",list);
            model.addAttribute("Error",mensaje2);
            return "/importacion/mostrarImportaciones";
          }
        else  {   
                imp.delete(idimport);
               List<Importacion> list=imp.findBynit(im.getNit());
              // List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
                model.addAttribute("usuario",u);
                model.addAttribute("importaciones",list);
                model.addAttribute("Exito",mensaje);
                return "/importacion/mostrarImportaciones";
        }
       }else{
       if(!vehiculodao.findByidimport(importa).isEmpty()){
            List<Importacion> list=(List<Importacion>) imp.findAll();
             //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            model.addAttribute("usuario",u);
            model.addAttribute("importaciones",list);
            model.addAttribute("Error",mensaje2);
            return "/importacion/mostrarImportaciones";
          }
        else  {   
                imp.delete(idimport);
               List<Importacion> list=(List<Importacion>) imp.findAll();
              // List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
                model.addAttribute("usuario",u);
                model.addAttribute("importaciones",list);
                model.addAttribute("Exito",mensaje);
                return "/importacion/mostrarImportaciones";
        }
       
       }
    }
        
        
       public Usuario obtenerUsuario(HttpSession session){
       usuario = (Usuario) session.getAttribute("usuario");
       return usuario;
       }
       
         public Importador obtenerImportadorByUsuario(Usuario u){
        i.setUsuario(u);
        i=importador.findByUsuario(u.getIdusuario());
        return i;
       }
}
