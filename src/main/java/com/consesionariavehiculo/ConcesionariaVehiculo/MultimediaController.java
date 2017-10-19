/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Detallevehdef;
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
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@MultipartConfig
@Controller
public class MultimediaController {
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
    @RequestMapping("/multimedia/new/{idvehiculo}")
	public ModelAndView multimediaImagenes(@PathVariable int idvehiculo, HttpSession session) {
          Usuario u = nomUsuario.obtenerUsuario(session);
          ve.setIdvehiculo(idvehiculo);
          multimedia.setIdvehiculo(ve);
          return new ModelAndView("/multimedia/agregarMultimedia").addObject("usuario",u).addObject("multimediaveh",multimedia);
        }
        
         
 //subir archivo
 /*@RequestMapping(value = "/uploadFile", method=RequestMethod.POST)
 
  public String uploadFile(HttpServletRequest request ,Model model) throws IOException, ServletException {
  Multimediaveh m=new Multimediaveh();
  Part foto=request.getPart("file");
  int fotosize = (int) foto.getSize();
  byte[] f=null; //el buffer
    if(fotosize>0){
    f=new byte[fotosize];
    try(DataInputStream dis=new DataInputStream(foto.getInputStream())){
        dis.readFully(f);     
    }
   }
    
    if (fotosize>0){
         m.setIdvehiculo(ve);
         long acumulador=0;
        m.setMultimedia(f);
       m.setIdvehiculo(ve);
      if(multimediavehdao.count()==0){
        m.setIdmultimediaveh(1);
        }
      else{
        acumulador=multimediavehdao.count();
        int valor=(int) acumulador;
         m.setIdmultimediaveh(valor+1);
        multimediavehdao.save(m);
      }
    }
 return "redirect:/multimedia/img/"+ve.getIdvehiculo();
  }
 */
 //=======================fUNCIONA CON UNA IMAGEN================================================
//@RequestMapping(value = "/uploadFiles", method=RequestMethod.POST)
 public String uploadFile(@RequestParam("file") MultipartFile file ,Model model) {
Multimediaveh m=new Multimediaveh();
FileInputStream fis = null;
  if (!file.isEmpty()) {
   try {
    byte[] bytes = file.getBytes();   
   /* long acumulador=0;
    m.setMultimedia(Base64.base64Encode(file.getBytes()));
       m.setIdvehiculo(ve);
      if(multimediavehdao.count()==0){
        m.setIdmultimediaveh(1);
        }
      else{
        acumulador=multimediavehdao.count();
        int valor=(int) acumulador;
         m.setIdmultimediaveh(valor+1);
        multimediavehdao.save(m);
      }*/
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
       m.setIdvehiculo(ve);
      if(multimediavehdao.count()==0){
        m.setIdmultimediaveh(1);
        }
      else{
        acumulador=multimediavehdao.count();
        int valor=(int) acumulador;
         m.setIdmultimediaveh(valor+1);
        multimediavehdao.save(m);
      }
      
      fis.close();
    
    logger.info("Ubicación de documento = " + serverFile.getAbsolutePath());
        fis.close();
       
    //return "Documento subido correctamente = " + file.getOriginalFilename() + " Ubicacion del Archivo = " + serverFile.getAbsolutePath();
  return "redirect:/multimedia/img/"+ve.getIdvehiculo();
   } catch (Exception e) {
    return "Ocurrio un error al subir documento" + file.getOriginalFilename() + " => " + e.getMessage();
   }
  } else {
   return "Ocurrio un error al subir " + file.getOriginalFilename() + " documento vacio.";
  }
 }
 //==========================FUNCIONA con un archivo ===========================================================
 @RequestMapping(value = "/prueba")
 public String pruebaImagen(Model model,HttpSession session){
 Multimediaveh m=new Multimediaveh();
 Usuario u = nomUsuario.obtenerUsuario(session);
  Vehiculo ve2=new Vehiculo();
  ve2.setIdvehiculo(1);
 
        long acumulador=0;
        
        try{
            FileInputStream fs=new FileInputStream("C:/temp/img.jpg");
            m.setMultimedia(IOUtils.toByteArray(fs));
            fs.close();
        }catch(Exception e){
        Assert.fail("No se puede leer archivo"+e.getMessage());
        }
       m.setIdvehiculo(ve2);
      if(multimediavehdao.count()==0){
        m.setIdmultimediaveh(1);
        }
      else{
        acumulador=multimediavehdao.count();
        int valor=(int) acumulador;
         m.setIdmultimediaveh(valor+1);
        multimediavehdao.save(m);
      }
       int  idm=(int) multimediavehdao.count();
       Multimediaveh m2=multimediavehdao.findOne(idm);
       
       byte[] byteleidos=m2.getMultimedia();
       byte[] encoded=Base64.base64Encode(byteleidos);
       String encodedString = new String(encoded); 
        try{
           FileOutputStream f= new FileOutputStream("C:/temp/img_nueva.jpg");
           IOUtils.write(byteleidos,f );
           f.close();
        }catch(Exception e){
        Assert.fail("No se puede escribir archivo"+e.getMessage());
        }
        
          model.addAttribute("usuario",u);
          model.addAttribute("imagen",encodedString);
            return "multimedia/mostrarImagenes";
 
 
 }
 
 
 /*
@RequestMapping(value = "/uploadFiles", method=RequestMethod.POST)
 public String uploadFile(@RequestParam("files") MultipartFile[] file,HttpSession session,Model model) {
       Usuario u = nomUsuario.obtenerUsuario(session);
for(MultipartFile f : file) {
  if (!f.isEmpty()) {
      try {
          byte[] bytes = f.getBytes();
          long acumulador=0;
          multimedia.setMultimedia(Base64.base64Encode(f.getBytes()));
          multimedia.setIdvehiculo(ve);
          if(multimediavehdao.count()==0){
              multimedia.setIdmultimediaveh(1);
          }
          else{
              acumulador=multimediavehdao.count();
              int valor=(int) acumulador;
              multimedia.setIdmultimediaveh(valor+1);
              multimediavehdao.save(multimedia);
                model.addAttribute("usuario",u);
          }
          
          
           
      } catch (IOException ex) {
          java.util.logging.Logger.getLogger(MultimediaController.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
 }
  return "redirect:/multimedia/img/"+ve.getIdvehiculo();
 }
 */

 //==========================FUNCIONA con muchos archivos===========================================================
@RequestMapping(value = "/uploadFiles", method=RequestMethod.POST)
 public String uploadFiles(@RequestParam("files") MultipartFile[] file,HttpSession session,Model model) {
       Usuario u = nomUsuario.obtenerUsuario(session);
       Multimediaveh m=new Multimediaveh();
       Tipomultimedia tm=new Tipomultimedia();
       FileInputStream fis = null;
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
            m.setMultimedia(IOUtils.toByteArray(fis));
            m.setIdvehiculo(ve);
            //Imagenes
            tm.setIdtipomultimedia(1);
            m.setIdtipomultimedia(tm);
            if(multimediavehdao.count()==0){
            m.setIdmultimediaveh(1);
            }
            else{
                acumulador=multimediavehdao.count();
                int valor=(int) acumulador;
                m.setIdmultimediaveh(valor+1);
              
            }  
              multimediavehdao.save(m);
            logger.info("Ubicación de documento = " + serverFile.getAbsolutePath());
           
           
          } catch (Exception e) {
                return "Ocurrio un error al subir documento" + f.getOriginalFilename() + " => " + e.getMessage();
            }        
    } else {
                return "Ocurrio un error al subir " + f.getOriginalFilename() + " documento vacio.";
    }
  }
 
  return "redirect:/multimedia/img/"+ve.getIdvehiculo();
 }

  @RequestMapping("/multimedia/img/{idvehiculo}")
	public String ListImagenes(@PathVariable int idvehiculo, HttpSession session,Model model){
            
            Usuario u = nomUsuario.obtenerUsuario(session);
            Vehiculo v=vehiculodao.findOne(idvehiculo);
            Tipomultimedia tm=new Tipomultimedia();
             tm.setIdtipomultimedia(1);
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
            return "multimedia/mostrarImagenes";
    }
        
     
    
         @RequestMapping("/multimediaVeh/find/{idimport}")
	public ModelAndView vehiculosImportacionMult(@PathVariable int idimport, HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session);
              Importacion importa= imp.findOne(idimport);
               
             importacion=idimport;
               List<Vehiculo> vehiculos = vehiculodao.findByidimport(importa);
              // List<Vehiculos> veview = vistaVehiculo.findByidimport(idimport);
               return new ModelAndView("/multimedia/busquedaMultimedia").addObject("usuario",u).addObject("vehiculo",vehiculos).addObject("idimport",idimport);
	}
        
        
        @RequestMapping("/multimedia/importaciones")
	public ModelAndView ListImportacionesVeh(HttpSession session){
           Usuario u = nomUsuario.obtenerUsuario(session);
            
           
           if(u.getIdrol()==3)
           {
               
               Importador im= obtenerImportadorByUsuario(u);
           
            System.out.println("Dentro del metodo de la vista");
            List<Importacion> list=imp.findBynit(im.getNit());
           // List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("multimedia/busquedaVehImportacion").addObject("usuario",u).addObject("importaciones",list);
    }else{
           
    List<Importacion> list=(List<Importacion>) imp.findAll();
           // List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
            return new ModelAndView("multimedia/busquedaVehImportacion").addObject("usuario",u).addObject("importaciones",list);        
   }
           
  }
        
    @RequestMapping("/agregarMultimedia")
	public ModelAndView agregar(HttpSession session,Model model){
         Usuario u = nomUsuario.obtenerUsuario(session); 
        return new ModelAndView("/multimedia/busquedaMultimedia").addObject("usuario",u);
    } 
        
       public Importador obtenerImportadorByUsuario(Usuario u){
        i.setUsuario(u);
        i=importador.findByUsuario(u.getIdusuario());
        return i;
       }    

        
        

}
