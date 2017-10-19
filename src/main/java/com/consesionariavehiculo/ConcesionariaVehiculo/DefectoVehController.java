/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Detallevehdef;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.DetalleVehDefectoDAO;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class DefectoVehController {
     General nomUsuario= new General();
     Detallevehdef dvd=new Detallevehdef();
     Vehiculo ve=new Vehiculo();
      @Autowired
      private DetalleVehDefectoDAO defectodao;
     
     @RequestMapping("/defecto/new/{idvehiculo}")
	public ModelAndView nuevoVehiculo(@PathVariable int idvehiculo, HttpSession session) {
          Usuario u = nomUsuario.obtenerUsuario(session);
          ve.setIdvehiculo(idvehiculo);
          dvd.setIdvehiculo(ve);
          return new ModelAndView("/vehiculo/nuevoDefecto").addObject("usuario",u).addObject("detallevehdef",dvd);
        }
        
        
  @RequestMapping(value="/defecto/add", method=RequestMethod.POST)
     public String agregarDefecto(@Valid Detallevehdef defecto,BindingResult result,HttpSession session,Model model) {
     Usuario u = nomUsuario.obtenerUsuario(session);
        long acumulador=0;    
      //  List<Detallevehdef> def = defecto.getDetallesdef();
        System.out.println(defecto);
         System.out.println(defecto.getIdvehiculo());
         System.out.println(defecto.getDetalledef());
         String[] ids = defecto.getDetalledef().split(",");
          System.out.println(ids);
	//System.out.println(defecto.getDetallesdef());
        
     /*    if(null != def && def.size() > 0) {

                for(Detallevehdef f : def) {
                f.setIdvehiculo(ve);
                     if(defectodao.count()==0){
                f.setIddetveh(1);
                }
                else
                acumulador=defectodao.count();
                int valor=(int) acumulador;
                 f.setIddetveh(valor+1);
                defectodao.save(f);
                    }
        }*/
         
      /* for(Detallevehdef f : defecto) {
        f.setIdvehiculo(ve);
             if(defectodao.count()==0){
        f.setIddetveh(1);
        }
        else
        acumulador=defectodao.count();
        int valor=(int) acumulador;
         f.setIddetveh(valor+1);
        defectodao.save(f);
        }*/
      for(int i=0;i<ids.length;i++) {
        defecto.setIdvehiculo(ve);
        defecto.setReparado(0);
       if(defectodao.count()==0){
       defecto.setIddetveh(1);
        }
        else
        acumulador=defectodao.count();
        int valor=(int) acumulador;
         defecto.setIddetveh(valor+1);
         defecto.setDetalledef(ids[i]);
        defectodao.save(defecto);
     }
       model.addAttribute("usuario",u);
       
       return "redirect:/multimedia/new/"+ve.getIdvehiculo();
     }
}
