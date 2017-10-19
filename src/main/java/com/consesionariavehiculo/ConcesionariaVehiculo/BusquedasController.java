/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.Imagenes;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Estado;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Marca;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Modelo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.MarcaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ModeloDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosAudioDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosImagenVistaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosImagenesVistaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosVideoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculos;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VehiculosAudio;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VehiculosImagen;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VehiculosImagenes;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VehiculosVideo;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Humberto
 */
@Controller
public class BusquedasController {
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
      private VehiculosImagenesVistaDAO vistaVehiculos;
      @Autowired
      private VehiculoDAO imp;
      @Autowired
      private VehiculosImagenVistaDAO vistaVehiculo;
       @Autowired
      private VehiculosAudioDAO vistaVehiculoA;
        @Autowired
      private VehiculosVideoDAO vistaVehiculoV;
     
     
   @RequestMapping("/vehiculo/buscar")
	public ModelAndView nuevoVehiculo(HttpSession session,Model model) {
           
               List<Marca> marcas=(List<Marca>) marcadao.findAll();
               List<Modelo> modelo=(List<Modelo>) modelodao.findAll();
               List<Vehiculos> veh= new  ArrayList<Vehiculos>();
               return new ModelAndView("/vehiculo/busquedaVehiculos").addObject("modelo",modelo).addObject("vehiculo",veh).addObject("lista1",marcas);
	}
        
           
       @RequestMapping("/vehiculo/busqueda")
       @ResponseBody
	public ModelAndView busquedaVehiculo(@RequestParam("marca") Integer marca ,@RequestParam("modelo") Integer modelo,@RequestParam("desde") Integer desde,@RequestParam("hasta") Integer hasta,HttpSession session,Model model){
        List<VehiculosImagen> veh= new  ArrayList<VehiculosImagen>();
        List<Imagenes> image = new ArrayList<Imagenes>();
        List<Marca> marcas=(List<Marca>) marcadao.findAll();
        List<Modelo> modelos=(List<Modelo>) modelodao.findAll();
         if(marca==0&&modelo==0){
          veh=vistaVehiculo.findByAniosBetween(desde, hasta);
          }else{
            if(marca!=0&&modelo==0){
                veh=vistaVehiculo.findByAniosBetweenAndIdmarca(marca, desde, hasta);
            }else{
                if(marca==0&&modelo!=0){
                    veh=vistaVehiculo.findByAniosBetweenAndIdmodelo(modelo, desde, hasta);
                }
                else{
                    veh=vistaVehiculo.findByAniosBetweenAndIdmarcaAndIdmodelo(marca, modelo, desde, hasta);
                }
            }
          }
                 for(VehiculosImagen f : veh) {
                    Imagenes ima=new Imagenes();
                    byte[] byteleidos=f.getImagen();
                    byte[] encoded=Base64.base64Encode(byteleidos);
                    String encodedString = new String(encoded);
                    ima.setImagen(encodedString);
                    ima.setIdvehiculo(f.getIdvehiculo());
                    ima.setIdimagenveh(f.getIdimagenveh());
                    ima.setNommarca(f.getNommarca());
                    ima.setNommodel(f.getNommodel());
                    ima.setAnio(f.getAnio());
                    ima.setIdestado(f.getIdestado());
                    ima.setPreciosalida(f.getPreciosalida());
                    image.add(ima);
             }
           
          return new ModelAndView("/vehiculo/busquedaVehiculos").addObject("modelo",modelos).addObject("vehiculo",image).addObject("lista1",marcas);
    }    
        
        
        @RequestMapping("/busqueda/view/{idvehiculo}")
	public ModelAndView ListImagenes(@PathVariable int idvehiculo, HttpSession session,Model model){
            Vehiculo veh=imp.findOne(idvehiculo);
          List<Imagenes> image = new ArrayList<Imagenes>();
           List<Imagenes> video = new ArrayList<Imagenes>();
            List<Imagenes> audio = new ArrayList<Imagenes>();
          List<VehiculosImagenes> vehi= new  ArrayList<VehiculosImagenes>();
          vehi=(List<VehiculosImagenes>) vistaVehiculos.findByidvehiculo(idvehiculo);
         List<VehiculosAudio> vehiaudio= new  ArrayList<VehiculosAudio>();
          vehiaudio=(List<VehiculosAudio>) vistaVehiculoA.findByidvehiculo(idvehiculo);
           List<VehiculosVideo> vehivideo= new  ArrayList<VehiculosVideo>();
          vehivideo=(List<VehiculosVideo>) vistaVehiculoV.findByidvehiculo(idvehiculo);
         
          image=convertirLista(vehi);
          audio=convertirListaAudio(vehiaudio);
          video=convertirListaVideo(vehivideo);
         
         return new ModelAndView("/busqueda/busquedaVehiculos").addObject("imagenes",image).addObject("audio",audio).addObject("video",video).addObject("vehiculo",veh);
        }
        
        
        
        List<Imagenes> convertirLista(List<VehiculosImagenes> lista){
         
            List<Imagenes> image = new ArrayList<Imagenes>();
         for(VehiculosImagenes f : lista) {
                    Imagenes ima=new Imagenes();
                    byte[] byteleidos=f.getImagen();
                    byte[] encoded=Base64.base64Encode(byteleidos);
                    String encodedString = new String(encoded);
                    ima.setImagen(encodedString);
                    ima.setIdvehiculo(f.getIdvehiculo());
                    ima.setIdimagenveh(f.getIdimagenveh());
                    ima.setNommarca(f.getNommarca());
                    ima.setNommodel(f.getNommodel());
                    ima.setAnio(f.getAnio());
                    ima.setIdestado(f.getIdestado());
                    ima.setPreciosalida(f.getPreciosalida());
                    image.add(ima);
             }
         
         return image;
        }
        
        List<Imagenes> convertirListaAudio(List<VehiculosAudio> lista){
         
            List<Imagenes> image = new ArrayList<Imagenes>();
         for(VehiculosAudio f : lista) {
                    Imagenes ima=new Imagenes();
                    byte[] byteleidos=f.getImagen();
                    byte[] encoded=Base64.base64Encode(byteleidos);
                    String encodedString = new String(encoded);
                    ima.setImagen(encodedString);
                    ima.setIdvehiculo(f.getIdvehiculo());
                    ima.setIdimagenveh(f.getIdimagenveh());
                    ima.setNommarca(f.getNommarca());
                    ima.setNommodel(f.getNommodel());
                    ima.setAnio(f.getAnio());
                    ima.setIdestado(f.getIdestado());
                    ima.setPreciosalida(f.getPreciosalida());
                    image.add(ima);
             }
         
         return image;
        }
        
        
        List<Imagenes> convertirListaVideo(List<VehiculosVideo> lista){
         
            List<Imagenes> image = new ArrayList<Imagenes>();
         for(VehiculosVideo f : lista) {
                    Imagenes ima=new Imagenes();
                    byte[] byteleidos=f.getImagen();
                    byte[] encoded=Base64.base64Encode(byteleidos);
                    String encodedString = new String(encoded);
                    ima.setImagen(encodedString);
                    ima.setIdvehiculo(f.getIdvehiculo());
                    ima.setIdimagenveh(f.getIdimagenveh());
                    ima.setNommarca(f.getNommarca());
                    ima.setNommodel(f.getNommodel());
                    ima.setAnio(f.getAnio());
                    ima.setIdestado(f.getIdestado());
                    ima.setPreciosalida(f.getPreciosalida());
                    image.add(ima);
             }
         
         return image;
        }
        
            
                 //ejemplo json 
    @RequestMapping(value = "/leerCombo4/", method = RequestMethod.POST)
    public String leerCombo2(@RequestParam(value = "id") Marca id,Model model) {
        List<Modelo> combo2 = (List<Modelo>) modelodao.modeloDep(id);
        model.addAttribute("itemList", combo2);
        return "/vehiculo/busquedaVehiculos::#item";
    }
}
    
