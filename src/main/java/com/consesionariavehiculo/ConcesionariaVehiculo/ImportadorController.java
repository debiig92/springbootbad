/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rol;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Taller;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportadorDAO;
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

/**
 *
 * @author user
 */
@Controller
public class ImportadorController {
   @Autowired
    private ImportadorDAO impRepo;
   General nomUsuario= new General();
    
    //cargar vista de taller 
    /*@RequestMapping(value="importador/nuevo")
    public String importador(){
        return "importador/nuevo";
    }*/
    
     @RequestMapping(value="/nuevoImportador")
    public ModelAndView importador(HttpSession session){
         Usuario u = nomUsuario.obtenerUsuario(session); 
         return new ModelAndView("/nuevoImportador").addObject("usuario",u);       
    }
    
    
     //operacion para registar importador
    /*@RequestMapping(value="/importador/add", method=RequestMethod.POST)
    public String CrearTaller(@ModelAttribute Importador importar){
            Importador emp=new Importador();
         
            emp=impRepo.findFirstByNit("1234554"); 
            System.out.println(emp.getNit());
            impRepo.save(importar);
            //direccion mientras cambiar al show de taller
            //return "redirect:/taller/"+taller.getIdtaller();
            
            return "redirect:/importador/showimport/"+importar.getNit();
    }*/
    
    
     @RequestMapping(value="/importador/guardar", method=RequestMethod.POST)
    public ModelAndView crearImportador(@Valid Importador importador, BindingResult bindingResult,HttpSession session){
        Usuario u = nomUsuario.obtenerUsuario(session);                
         Importador emp=new Importador();                  
         //emp=impRepo.findFirstByNit("1234554"); 
         //System.out.println(emp.getNit());
         impRepo.save(importador);
         ModelAndView modelandview= new ModelAndView("/nuevoImportador");
         String mensaje="Importador Creado!!!";
        return modelandview.addObject("usuario",u).addObject("mensaje",mensaje);  
    }
    
    //mostrar datos de un importador show
    @RequestMapping("importador/showimport/{nit}")
    public String showImportador(@PathVariable String nit, Model model){
        
        model.addAttribute("importador",impRepo.findFirstByNit(nit));
        //model.addAttribute("taller",tallerRepo.findOne(idtaller));
        return "importador/showimport";
    }
    
    //actualizacion de datos de importador
      
    
    //carga la pagina del edit y asigna datos a su contenido
    @RequestMapping("/importador/edit/{nit}")
    public String tallerEdit(@PathVariable String nit, Model model){
        model.addAttribute("importador",impRepo.findFirstByNit(nit));
        return "importador/editar";
    }
    
    //actualizar datos en la base
    @RequestMapping(value="/importador/update", method=RequestMethod.POST)
    public String actualizar(Importador imp){
	impRepo.save(imp);
	return "redirect:/importador/showimport/"+imp.getNit();
    }
    
    //muestra todos los datos de los talleres
    @RequestMapping(value="/principalimportador")
	public ModelAndView ListImportador(HttpSession session){
            Usuario u = nomUsuario.obtenerUsuario(session);
            ModelAndView modelandview= new ModelAndView("/principalimportador");
            List<Importador> list=(List<Importador>) impRepo.findAll();
            return modelandview.addObject("usuario",u).addObject("importadorList",list);
    }
        
    
    //eliminar un taller
    @RequestMapping(value="/importador/delete/{nit}",method=RequestMethod.GET)
    public String eliminar(@PathVariable String nit){
        impRepo.removeByNit(nit);
        //mensaje de eliminacion falta q lo muestre en la pantalla
        String message="Importador eliminado";
        return "redirect:/importador/principalimp";
    }
 
}
