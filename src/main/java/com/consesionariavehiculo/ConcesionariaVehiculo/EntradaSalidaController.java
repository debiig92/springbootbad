/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodeguero;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Entsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Motorista;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rentsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Taller;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Remolque;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculoremolque;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.BodegueroDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.EntsalvehDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportadorDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.MotoristaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.RelacionentsalDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.RentsalvehDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.Vehiculo_RemolqueDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Relacionentsal;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculos;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class EntradaSalidaController {
    
    Importador i= new Importador();
   
    General nomUsuario= new General();
    @Autowired
    private Vehiculo_RemolqueDAO ve_rem;
    @Autowired
    private MotoristaDAO motoristaDao;
     @Autowired
    private BodegueroDAO bodegueroDao;
    @Autowired
    private EntsalvehDAO entsalvehDao;
    @Autowired
    private ImportacionDAO imp;
     @Autowired
    private ImportadorDAO importador;
      @Autowired
      private VehiculosViewDAO vistaVehiculo;
         @Autowired
      private RentsalvehDAO rentsalvedao;
           @Autowired
      private RelacionentsalDAO relaciondao;
      @Autowired
    private VehiculoDAO vehiculodao;
     /*PROCESO DE REPARACION*/
    @RequestMapping("/autorizarentradasalida/{identsalveh}")
    public ModelAndView entradasalida(@PathVariable int identsalveh, HttpSession session) {
       Usuario u = nomUsuario.obtenerUsuario(session);
        ModelAndView vista = new ModelAndView();
        vista.setViewName("entradasalida/entradasalida");
        List<Vehiculo_Remolque> list3 = (List<Vehiculo_Remolque>) ve_rem.findAll();
        List<Motorista> list4 = (List<Motorista>) motoristaDao.findAll();
        List<Bodeguero> bodegueros = (List<Bodeguero>) bodegueroDao.findAll();
        vista.addObject("lista3", list3);
        vista.addObject("lista4", list4);
        vista.addObject("identsalveh", identsalveh);
        vista.addObject("bodegueros", bodegueros);
        vista.addObject("usuario", u);
        return vista;
    }
    
    
    
    @RequestMapping("/autorizarE")
    public ModelAndView guardarSalTaller(@RequestParam("identsalveh") Integer identsalveh,@RequestParam("idbodeguero") Integer idbodeguero,@RequestParam("placarem") String placarem,@RequestParam("duimotorista") String duimotorista,@RequestParam("fechaentsal") Date fechaentsal, HttpSession session) {
        Usuario u = nomUsuario.obtenerUsuario(session);
        Motorista d= new Motorista();
        d.setDuimotorista(duimotorista);
        Bodeguero bode=new Bodeguero();
        bode.setIdbodeguero(idbodeguero);
        Vehiculoremolque rem=new Vehiculoremolque();
        rem.setPlacarem(placarem);
        Entsalveh e=new Entsalveh();
        e.setIdentsalveh(identsalveh);
        e.setDuimotorista(d);
        e.setEntsalautorizada(1);
        e.setFechaentsal(fechaentsal);
        e.setIdbodeguero(bode);
        e.setPlacarem(rem);
        entsalvehDao.save(e);
        
        List<Vehiculo> carros=rentsalvedao.findByidentsalveh(e);
        for(int x=0;x<carros.size();x++) {
        vehiculodao.updateIdestado(carros.get(x).getIdvehiculo());
        }
        String mensaje = "Solicitud Actualizada con Exito!!!";
        ModelAndView vista = new ModelAndView();
        vista.setViewName("autorizar/autorizarentrada");
        vista.addObject("usuario", u);
        vista.addObject("mensaje", mensaje);
        return vista;
    }
    
    
        @RequestMapping("/solicitud")
    public ModelAndView entradasalidaSol(HttpSession session) {
       Usuario u = nomUsuario.obtenerUsuario(session);
       ModelAndView vista = new ModelAndView();
       vista.setViewName("entradasalida/solicitud");
       List<Vehiculos> veview = (List<Vehiculos>) vistaVehiculo.findByidestado(7);
        vista.addObject("vehiculo", veview); 
       vista.addObject("usuario", u);
        return vista;
    }
    
      public Importador obtenerImportadorByUsuario(Usuario u){
        i.setUsuario(u);
        i=importador.findByUsuario(u.getIdusuario());
        return i;
       }
      
      
  
      @RequestMapping(value = "/solicitar")
    public ModelAndView guardarSolicitud(@RequestParam("autos[]") Integer[] autos,@RequestParam("fechaentsal") Date fechaentsal,HttpSession session) {
        Usuario u = nomUsuario.obtenerUsuario(session);
        Entsalveh entsalveh=new Entsalveh();
        long acumulador = 0;
     
        if (entsalvehDao.count() == 0) {
            entsalveh.setIdentsalveh(1);
        } else {
            acumulador = entsalvehDao.count();
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        entsalveh.setIdentsalveh(valor + 1);
        }
        entsalvehDao.save(entsalveh);
       
        
        // oara cada auto que quiero autorizar
        for(int i=0; i<autos.length; i++){
        Rentsalveh rs=new Rentsalveh();
        Vehiculo ve=new Vehiculo();
        ve.setIdvehiculo(autos[i]);
        rs.setIdentsalveh(entsalveh);
        rs.setIdvehiculo(ve);
        rs.setMotivo("Primera entrada a Bodega");
        rs.setNit(obtenerImportadorByUsuario(u));
        
        if (rentsalvedao.count() == 0) {
            rs.setIdrentsalveh(1);
        } else {
            acumulador = rentsalvedao.count();
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        rs.setIdrentsalveh(valor + 1);
        }
        rentsalvedao.save(rs);
        }
        
        String mensaje = "Solicitud Realizada con Exito!!!";
        ModelAndView vista = new ModelAndView();
        vista.setViewName("entradasalida/solicitud");
        vista.addObject("usuario", u);
        vista.addObject("mensaje", mensaje);
        return vista;
        
    }
    
    
    
      /*PROCESO DE REPARACION*/
    @RequestMapping("/entradasalidasolicitudes")
    public ModelAndView entradasalidaAutorizar(HttpSession session) {
       Usuario u = nomUsuario.obtenerUsuario(session);
        ModelAndView vista = new ModelAndView();
        vista.setViewName("autorizar/autorizarentrada");
    List<Entsalveh> e=entsalvehDao.findByEntsalautorizadaIsNull();
  //  List<Relacionentsal> re=(List<Relacionentsal>) relaciondao.findAll();
      vista.addObject("entsalveh", e);
        vista.addObject("usuario", u);
        return vista;
    }
    
    
      /*PROCESO DE REPARACION*/
    @RequestMapping("/verentradasalidasolicitudes")
    public ModelAndView verentradasalidaAutorizar(HttpSession session) {
       Usuario u = nomUsuario.obtenerUsuario(session);
        ModelAndView vista = new ModelAndView();
        vista.setViewName("autorizar/verAutorizaciones");
   // List<Entsalveh> e=entsalvehDao.findByEntsalautorizadaIsNull();
   List<Relacionentsal> re=(List<Relacionentsal>) relaciondao.findAll();
      vista.addObject("rentsalveh", re);
        vista.addObject("usuario", u);
        return vista;
    }
    
      
}
