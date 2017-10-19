/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Multimediaveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Tipomultimedia;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionesViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportadorDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.MultimediaVehDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Importaciones;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class AudioController {
    
        int importacion;
        General nomUsuario= new General();
        Vehiculo ve=new Vehiculo();
        Importador i= new Importador();
        Multimediaveh multimedia=new Multimediaveh();
        private static final Logger logger = LoggerFactory.getLogger(MultimediaController.class);
        @Autowired
        private MultimediaVehDAO multimediavehdao;
        @Autowired
        private VehiculoDAO vehiculodao;
        @Autowired
        private ImportadorDAO importador;
        @Autowired
        private ImportacionDAO imp;
        @Autowired
        private VehiculosViewDAO vistaVehiculo;
        @Autowired
        private ImportacionesViewDAO vistaImportacion;
        
        
        
          @RequestMapping("/multimedia/importacionesA")
	public ModelAndView ListImportacionesVeh(HttpSession session){
           Usuario u = nomUsuario.obtenerUsuario(session);
           
           if(u.getIdrol()==3){
            Importador im= obtenerImportadorByUsuario(u);
            System.out.println("Dentro del metodo de la vista");
            List<Importacion> list=imp.findBynit(im.getNit());
            //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("multimedia/audio/busquedaImportacion").addObject("usuario",u).addObject("importaciones",list);
           }
           else{
           List<Importacion> list=(List<Importacion>) imp.findAll();
            //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("multimedia/audio/busquedaImportacion").addObject("usuario",u).addObject("importaciones",list);
           
           
           }
           
           }
        
        
    @RequestMapping("/audiomultimedia/new/{idvehiculo}")
	public ModelAndView multimediaImagenes(@PathVariable int idvehiculo, HttpSession session) {
          Usuario u = nomUsuario.obtenerUsuario(session);
          ve.setIdvehiculo(idvehiculo);
          multimedia.setIdvehiculo(ve);
          return new ModelAndView("/multimedia/audio/agregarAudio").addObject("usuario",u).addObject("multimediaveh",multimedia);
        }
        
    
    //===============================AUDIO=================================================
//=======================fUNCIONA CON UNA IMAGEN================================================
@RequestMapping(value = "/uploadAudio", method=RequestMethod.POST)
 public String uploadFile(@RequestParam("file") MultipartFile file ,Model model) {
Multimediaveh m=new Multimediaveh();
 Tipomultimedia tm=new Tipomultimedia();
FileInputStream fis = null;
  if (!file.isEmpty()) {
   try {
    byte[] bytes = file.getBytes();   
    // Crear el directorio para almacenar el archivo
    String rootPath = System.getProperty("catalina.home");
    File dir = new File(rootPath + File.separator + "tmpFiles");
    
    if (!dir.exists())
     dir.mkdirs();

    // Crear documento en el servidor
    File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
    stream.write(bytes);
    stream.close();

    
       File img = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
       fis = new FileInputStream(img);
       long acumulador=0;
       m.setMultimedia(IOUtils.toByteArray(fis));
       tm.setIdtipomultimedia(2);// es audio
       m.setIdtipomultimedia(tm);
       m.setIdvehiculo(ve);
      if(multimediavehdao.count()==0){
        m.setIdmultimediaveh(1);
        }
      else{
        acumulador=multimediavehdao.count();
        int valor=(int) acumulador;
         m.setIdmultimediaveh(valor+1);
       
      }
       multimediavehdao.save(m);
      fis.close();
    
    logger.info("Ubicación de documento = " + serverFile.getAbsolutePath());
        fis.close();
       
    //return "Documento subido correctamente = " + file.getOriginalFilename() + " Ubicacion del Archivo = " + serverFile.getAbsolutePath();
  
   } catch (Exception e) {
    return "Ocurrio un error al subir documento" + file.getOriginalFilename() + " => " + e.getMessage();
   }
  } else {
   return "Ocurrio un error al subir " + file.getOriginalFilename() + " documento vacio.";
  }
  return "redirect:/multimedia/audio/"+ve.getIdvehiculo();
 }

  @RequestMapping("/multimedia/audio/{idvehiculo}")
	public String ListImagenes(@PathVariable int idvehiculo, HttpSession session,Model model){
            
            Usuario u = nomUsuario.obtenerUsuario(session);
            Vehiculo v=vehiculodao.findOne(idvehiculo);
              Tipomultimedia tm=new Tipomultimedia();
             tm.setIdtipomultimedia(2);
             List<Multimediaveh> m2 = multimediavehdao.findByidvehiculoAndIdtipomultimedia(v,tm);
            //Multimediaveh m2 = multimediavehdao.findByidvehiculo(v);
             List<String> imagenes = new ArrayList<String>();
             for(Multimediaveh f : m2) {
             byte[] byteleidos=f.getMultimedia();
             byte[] encoded=Base64.base64Encode(byteleidos);
             String encodedString = new String(encoded);
             imagenes.add(encodedString);
             }
             model.addAttribute("usuario",u);
             model.addAttribute("imagenes",imagenes);
            return "multimedia/audio/mostrarAudio";
    }
        
     
    
         @RequestMapping("/multimediaVeh/findA/{idimport}")
	public ModelAndView vehiculosImportacionMult(@PathVariable int idimport, HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session);
              Importacion importa= imp.findOne(idimport);
               
             importacion=idimport;
               List<Vehiculo> vehiculos = vehiculodao.findByidimport(importa);
              // List<Vehiculos> veview = vistaVehiculo.findByidimport(idimport);
               return new ModelAndView("/multimedia/audio/busquedaVehiculo").addObject("usuario",u).addObject("vehiculo",vehiculos).addObject("idimport",idimport);
	}
        
        
      
        
     
       public Importador obtenerImportadorByUsuario(Usuario u){
        i.setUsuario(u);
        i=importador.findByUsuario(u.getIdusuario());
        return i;
       }    
}
