/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Estado;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Marca;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Modelo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionesViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportadorDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.MarcaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ModeloDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Importaciones;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculos;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Humberto
 */
@Controller
public class VehiculoController {
      Usuario usuario;
      int importacion;
      Vehiculo ve=new Vehiculo();
      Importador i= new Importador();
      General nomUsuario= new General();
      Importacion im=new Importacion();
      Estado e=new Estado();
      @Autowired
      private MarcaDAO marcadao;
      @Autowired
      private ModeloDAO modelodao;
      @Autowired
      private VehiculoDAO vehiculodao;
       @Autowired
    private ImportacionDAO imp;
    @Autowired
    private ImportadorDAO importador;
    @Autowired
    private ImportacionesViewDAO vistaImportacion;
     @Autowired
    private VehiculosViewDAO vistaVehiculo;
      @Autowired
    private MarcaDAO marcaDAO;
    @Autowired
    private ModeloDAO modeloDAO;
        @RequestMapping("/vehiculo/new/{idimport}")
	public ModelAndView nuevoVehiculo(@PathVariable int idimport, HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session);
               im=imp.findOne(idimport);
               ve.setIdimport(im);
               importacion=idimport;
               List<Marca> marcas=(List<Marca>) marcadao.findAll();
               List<Modelo> modelo=(List<Modelo>) modelodao.findAll();
               
               return new ModelAndView("/vehiculo/nuevoVehiculo").addObject("usuario",u).addObject("idmodelo",modelo).addObject("vehiculo",ve).addObject("lista1",marcas);
	}
        
    /*    @RequestMapping(value = "/modelo/{idmarca}")
     @ResponseBody
        public Set getRegions(@RequestParam String marca) {
         Map<String, Set<String>> modelo = (Map<String, Set<String>>) modelodao.findByidmarca(marca);
        return modelo.get(marca);
}*/
        
        @RequestMapping(value="/vehiculo/add", method=RequestMethod.POST)
     
    public String crearVehiculo(@Valid Vehiculo vehiculo,BindingResult result,HttpSession session,Model model) {
       Usuario u = nomUsuario.obtenerUsuario(session);
        List<Marca> marcas=(List<Marca>) marcadao.findAll();
        List<Modelo> modelo=(List<Modelo>) modelodao.findAll();
        e.setIdestado(7);
        long acumulador=0;
        vehiculo.setIdestado(e);
        vehiculo.setIdimport(im);
      if(vehiculodao.count()==0){
        vehiculo.setIdvehiculo(1);
        }
        else
        acumulador=vehiculodao.count();
        int valor=(int) acumulador;
         vehiculo.setIdvehiculo(valor+1);
        vehiculodao.save(vehiculo);
       model.addAttribute("usuario",u);
       
         return "redirect:/defecto/new/"+(valor+1);
    }
    
      @RequestMapping("/vehiculo/importaciones")
	public ModelAndView ListImportacionesCon(HttpSession session){
           Usuario u = nomUsuario.obtenerUsuario(session);
           if(u.getIdrol()==3){ 
           Importador im2= obtenerImportadorByUsuario(u);
             System.out.println("Dentro del metodo de la vista");
            List<Importacion> list=imp.findBynit(im2.getNit());
           // List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
              return new ModelAndView("vehiculo/registrarVehiculos").addObject("usuario",u).addObject("importaciones",list);
           }
           else{
           List<Importacion> list=(List<Importacion>) imp.findAll();
           // List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
              return new ModelAndView("vehiculo/registrarVehiculos").addObject("usuario",u).addObject("importaciones",list);
           }
         
    }
         
         public Importador obtenerImportadorByUsuario(Usuario u){
        i.setUsuario(u);
        i=importador.findByUsuario(u.getIdusuario());
        return i;
       }
       

         
           @RequestMapping("/vehiculos/importaciones")
	public ModelAndView ListImportacionesVeh(HttpSession session){
           Usuario u = nomUsuario.obtenerUsuario(session);
            if(u.getIdrol()==3){ 
            Importador im2= obtenerImportadorByUsuario(u);
            System.out.println("Dentro del metodo de la vista");
            List<Importacion> list=imp.findBynit(im2.getNit());
            //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("vehiculo/consultarVehiculos").addObject("usuario",u).addObject("importaciones",list);
            }else{
              System.out.println("Dentro del metodo de la vista");
            List<Importacion> list=(List<Importacion>) imp.findAll();
            //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("vehiculo/consultarVehiculos").addObject("usuario",u).addObject("importaciones",list);
            
            }
            
       }
        
        
        @RequestMapping("/vehiculo/find/{idimport}")
	public ModelAndView vehiculosImportacion(@PathVariable int idimport, HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session);
              Importacion importa= imp.findOne(idimport);
               
               importacion=idimport;
               List<Vehiculo> vehiculos = vehiculodao.findByidimport(importa);
              // List<Vehiculos> veview = vistaVehiculo.findByidimport(idimport);
               return new ModelAndView("/vehiculo/vehiculosImportacion").addObject("usuario",u).addObject("vehiculo",vehiculos).addObject("idimport",idimport);
	}
        
        
     //carga la pagina del edit y asigna datos a su contenido
    @RequestMapping("/vehiculo/edit/{idvehiculo}")
    public String vehiculoEdit(@PathVariable int idvehiculo, Model model,HttpSession session){
        Usuario u = nomUsuario.obtenerUsuario(session);
        Vehiculo v = vehiculodao.findOne(idvehiculo);
        List<Marca> marcas=(List<Marca>) marcadao.findAll();
        List<Modelo> modelo=(List<Modelo>) modelodao.findAll();
        model.addAttribute("usuario",u);
        model.addAttribute("vehiculo",v);
        model.addAttribute("idmarca",marcas);
        model.addAttribute("idmodelo",modelo);
        return "vehiculo/vehiculoActualizar";
    }
    
    //actualizar datos en la base
    @RequestMapping(value="/vehiculo/update", method=RequestMethod.POST)
    public String actualizar(@Valid Vehiculo vehiculo ,BindingResult result,HttpSession session,Model model){
        Usuario u = nomUsuario.obtenerUsuario(session);
       String mensaje="Vehiculo Actualizado con Exito!!";
       vehiculodao.save(vehiculo);
      // List<Importacion> list=imp.findBynit(im.getNit());
      List<Vehiculo> imv=vehiculodao.findByidimport(vehiculo.getIdimport());
       model.addAttribute("usuario",u);
       model.addAttribute("vehiculo",imv);
       model.addAttribute("Exito",mensaje);
	return "/vehiculo/vehiculosImportacion";
    }
    
    
        
    //eliminar un taller
   /* @RequestMapping(value="/vehiculo/delete/{idvehiculo}",method=RequestMethod.GET)
    public String eliminar(@PathVariable Integer idvehiculo,HttpSession session, Model model){
       Usuario u = nomUsuario.obtenerUsuario(session);
       String mensaje2="No puede borrar Vehiculo!, Posee Datos relacionados";   
       String mensaje="Vehiculo Borrado con Exito!!";
       Vehiculo vehi=vehiculodao.findOne(idvehiculo);
       
        if(!vehiculodao.findByidimport(idimport).isEmpty()){
            //List<Importacion> list=imp.findBynit(im.getNit());
             List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            model.addAttribute("usuario",u);
            model.addAttribute("importaciones",imv);
            model.addAttribute("Error",mensaje2);
            return "/importacion/mostrarImportaciones";
          }
        else  {   
                imp.delete(idimport);
               // List<Importacion> list=imp.findBynit(im.getNit());
               List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
                model.addAttribute("usuario",u);
                model.addAttribute("importaciones",imv);
                model.addAttribute("Exito",mensaje);
                return "/importacion/mostrarImportaciones";
        }
    }*/
    
    //combobox de debora
    @RequestMapping("combobox")
    public ModelAndView vista() {
        ModelAndView vista = new ModelAndView("Bodega/vistaCombo");
        List<Marca> combo1 = (List<Marca>) marcaDAO.findAll();                
        vista.addObject("lista1", combo1);
        return vista;
    }

    //ejemplo json 
    @RequestMapping(value = "/leerCombo2/", method = RequestMethod.POST)
    public String leerCombo2(@RequestParam(value = "id") Marca id,Model model) {
        List<Modelo> combo2 = (List<Modelo>) modeloDAO.modeloDep(id);
        model.addAttribute("itemList", combo2);
        return "/vehiculo/nuevoVehiculo::#item";
    }
     
       
}
