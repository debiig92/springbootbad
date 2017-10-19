/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Estado;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Imagenveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Multimediaveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Tipomultimedia;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImagenVehDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionesViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportadorDAO;
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
 * @author Humberto
 */
@Controller
public class ImagenVehController {
    int importacion;
     General nomUsuario= new General();
     Vehiculo ve=new Vehiculo();
     Importador i= new Importador();
     Imagenveh multimedia=new Imagenveh();
     @Autowired
     private ImagenVehDAO imagenvehdao;
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
    
     public Importador obtenerImportadorByUsuario(Usuario u){
        i.setUsuario(u);
        i=importador.findByUsuario(u.getIdusuario());
        return i;
       }  
        @RequestMapping("/imagenVeh/importaciones")
	public ModelAndView ListImportacionesVeh(HttpSession session){
           Usuario u = nomUsuario.obtenerUsuario(session);
           if(u.getIdrol()==3){
            Importador im= obtenerImportadorByUsuario(u);
            System.out.println("Dentro del metodo de la vista");
            List<Importacion> list=imp.findBynit(im.getNit());
            //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("imagenveh/busquedaVehImportacion").addObject("usuario",u).addObject("importaciones",list);
           }
           else{
            List<Importacion> list=(List<Importacion>) imp.findAll();
            //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("imagenveh/busquedaVehImportacion").addObject("usuario",u).addObject("importaciones",list);
           
           }
        }
        
        
        
         @RequestMapping("/imagenVeh/find/{idimport}")
	public ModelAndView vehiculosImportacionImg(@PathVariable int idimport, HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session);
               Importacion importa= imp.findOne(idimport);
               Estado e=new Estado();
               e.setIdestado(3);
               importacion=idimport;
               List<Vehiculo> vehiculos = vehiculodao.findByidimportAndIdestado(importa, e);
              // List<Vehiculos> veview = vistaVehiculo.findByidimport(idimport);
               return new ModelAndView("/imagenVeh/busquedaVehiculos").addObject("usuario",u).addObject("vehiculo",vehiculos).addObject("idimport",idimport);
	}
        
        @RequestMapping("/imagenveh/agregar/{idvehiculo}")
	public ModelAndView multimediaImagenes(@PathVariable int idvehiculo, HttpSession session) {
          Usuario u = nomUsuario.obtenerUsuario(session);
          ve.setIdvehiculo(idvehiculo);
          multimedia.setIdvehiculo(ve);
          return new ModelAndView("/imagenveh/agregarImagen").addObject("usuario",u).addObject("imagenveh",multimedia);
        }
        
        
        //==========================FUNCIONA con muchos archivos===========================================================
@RequestMapping(value = "/uploadFilesVenta", method=RequestMethod.POST)
 public String uploadFiles(@RequestParam("files") MultipartFile[] file,HttpSession session,Model model) {
       Imagenveh m=new Imagenveh();
       FileInputStream fis = null;
       Tipomultimedia tm=new Tipomultimedia();
       // Crear el directorio para almacenar el archivo
            String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "tmpFiles");
    
            if (!dir.exists()){
             dir.mkdirs();
            }
    for(MultipartFile f : file) {
        if (!f.isEmpty()) {
            try {
            byte[] bytes = f.getBytes();   
            
            // Crear documento en el servidor
            File serverFile = new File(dir.getAbsolutePath() + File.separator + f.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

    
            File img = new File(dir.getAbsolutePath() + File.separator + f.getOriginalFilename());
            fis = new FileInputStream(img);
            long acumulador=0;
            m.setImagen(IOUtils.toByteArray(fis));
            m.setIdvehiculo(ve);
            //Imagenes
            tm.setIdtipomultimedia(1);
            m.setIdtipomultimedia(tm);
            if(imagenvehdao.count()==0){
            m.setIdimagenveh(1);
            }
            else{
                acumulador=imagenvehdao.count();
                int valor=(int) acumulador;
                m.setIdimagenveh(valor+1);
                
            }  
           imagenvehdao.save(m);
          } catch (Exception e) {
                return "Ocurrio un error al subir documento" + f.getOriginalFilename() + " => " + e.getMessage();
            }        
    } else {
                return "Ocurrio un error al subir " + f.getOriginalFilename() + " documento vacio.";
    }
  }
 
  return "redirect:/imagenveh/img/"+ve.getIdvehiculo();
 }

  @RequestMapping("/imagenveh/img/{idvehiculo}")
	public String ListImagenes(@PathVariable int idvehiculo, HttpSession session,Model model){
            
            Usuario u = nomUsuario.obtenerUsuario(session);
            Vehiculo v=vehiculodao.findOne(idvehiculo);
            Tipomultimedia tm=new Tipomultimedia();
             tm.setIdtipomultimedia(1);
             List<Imagenveh> m2 = imagenvehdao.findByidvehiculoAndIdtipomultimedia(v,tm);
            //Multimediaveh m2 = multimediavehdao.findByidvehiculo(v);
             List<String> imagenes = new ArrayList<String>();
             for(Imagenveh f : m2) {
             byte[] byteleidos=f.getImagen();
             byte[] encoded=Base64.base64Encode(byteleidos);
             String encodedString = new String(encoded);
             imagenes.add(encodedString);
             }
             model.addAttribute("usuario",u);
             model.addAttribute("imagenes",imagenes);
            return "imagenveh/mostrarImagenes";
    }
        
        
}
