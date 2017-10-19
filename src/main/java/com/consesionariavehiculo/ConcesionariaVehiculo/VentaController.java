/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Cliente;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Clienteveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Marca;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Modelo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ClienteDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ClienteVehDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.MarcaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ModeloDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosVentaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VentasClienteDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculos;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculosventa;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VentasCliente;
import java.util.ArrayList;
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
public class VentaController {
     General nomUsuario= new General();
      @Autowired
      private VehiculosViewDAO vistaVehiculo;
      @Autowired
      private ClienteVehDAO clienteveh;
      @Autowired
      private ClienteDAO clientedao;
      @Autowired
      private VehiculoDAO vehiculodao;
       @Autowired
      private VentasClienteDAO vcdao;
       @Autowired
      private MarcaDAO marcadao;
      @Autowired
      private ModeloDAO modelodao;
       @Autowired
      private VehiculosVentaDAO ventaVehiculo;
      

     @RequestMapping("/venta/busqueda")
	public ModelAndView vehiculosVenta(HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session); 
               List<Marca> marcas=(List<Marca>) marcadao.findAll();
               List<Modelo> modelo=(List<Modelo>) modelodao.findAll();
               List<Vehiculosventa> veview = (List<Vehiculosventa>) ventaVehiculo.findAll();
               return new ModelAndView("/venta/ventaVehiculo").addObject("usuario",u).addObject("vehiculo",veview).addObject("modelo",modelo).addObject("marcas",marcas);
	}
        
        
        // vista para Vender vehiculo
        @RequestMapping("/venta/new/{idvehiculo}")
	public ModelAndView registroCliente(@PathVariable int idvehiculo, HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session); 
               Vehiculo vehiculo=vehiculodao.findOne(idvehiculo);
               List<Cliente> c=(List<Cliente>) clientedao.findAll();
               return new ModelAndView("/venta/registroVenta").addObject("usuario",u).addObject("vehiculo",vehiculo).addObject("duicliente",c);
	}
        
     //Guardar registro de venta de vehiculos   
     @RequestMapping(value="/venta/add", method=RequestMethod.POST)
     public ModelAndView registrarVenta(@Valid Clienteveh cliente,BindingResult result,HttpSession session) {
        Usuario u = nomUsuario.obtenerUsuario(session);          
        
        long acumulador=0;
        cliente.setEntregado(0);
        cliente.setIdusuario(u);
        if(clienteveh.count()==0){
        cliente.setIdclienteveh(1);
        }
        else
        acumulador=clienteveh.count();
        int valor=(int) acumulador;
        cliente.setIdclienteveh(valor+1);
        ModelAndView modelandview= new ModelAndView("venta/ventaVehiculo");
        clienteveh.save(cliente);
       // List<Vehiculos> veview = (List<Vehiculos>) vistaVehiculo.findAll();
         List<Vehiculosventa> veview = (List<Vehiculosventa>) ventaVehiculo.findAll();
        String mensaje="Venta Registrada!!!";
        return modelandview.addObject("usuario",u).addObject("mensaje",mensaje).addObject("vehiculo",veview);    
        
    }
    
     
     // VIsta para conssultar registro de venta de vehiculo
    
     @RequestMapping("/venta/consulta")
	public ModelAndView vehiculosVentaC(HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session);
               List<Marca> marcas=(List<Marca>) marcadao.findAll();
               List<Modelo> modelo=(List<Modelo>) modelodao.findAll();
               //List<Clienteveh> c=(List<Clienteveh>) clienteveh.findByidusuario(u);
               List<VentasCliente> vc=vcdao.findByidusuario(u.getIdusuario());
               return new ModelAndView("/venta/consultaVenta").addObject("usuario",u).addObject("clienteveh",vc).addObject("modelo",modelo).addObject("marcas",marcas);
	}
        
        
          
     // VIsta para conssultar registro de venta de vehiculo, entrega
    
     @RequestMapping("/venta/entrega")
	public ModelAndView vehiculosVentaEntrega(HttpSession session) {
               Usuario u = nomUsuario.obtenerUsuario(session);
       
               //List<Clienteveh> c=(List<Clienteveh>) clienteveh.findByidusuario(u);
               List<VentasCliente> vc=(List<VentasCliente>) vcdao.findByentregado(0);
               return new ModelAndView("/venta/entregarVehiculo").addObject("usuario",u).addObject("clienteveh",vc);
	}
        
        
         //carga la pagina del edit y asigna datos a su contenido
    @RequestMapping("/venta/edit/{idvehiculo}")
    public String ventaEdit(@PathVariable int idvehiculo, Model model,HttpSession session){
       Usuario u = nomUsuario.obtenerUsuario(session);
        List<Cliente> cli=(List<Cliente>) clientedao.findAll();
        Clienteveh c=clienteveh.findOne(idvehiculo);
       
        model.addAttribute("usuario",u);
        model.addAttribute("clienteveh",c);
        model.addAttribute("duicliente",cli);
        return "venta/actualizaVenta";
    }
    
   //actualizar datos en la base
    @RequestMapping(value="/venta/update", method=RequestMethod.POST)
    public String actualizar(@Valid Clienteveh cliente ,BindingResult result,HttpSession session,Model model){
       Usuario u = nomUsuario.obtenerUsuario(session);
       String mensaje="Venta Actualizada con Exito!!";
       cliente.setIdusuario(u);
       cliente.setEntregado(0);
       clienteveh.save(cliente);
      // List<Clienteveh> c=(List<Clienteveh>) clienteveh.findByidusuario(u);
      //List<Importaciones> imv=vistaImportacion.findBynit(im.getNit());
       List<VentasCliente> vc=vcdao.findByidusuario(u.getIdusuario());
       model.addAttribute("usuario",u);
       model.addAttribute("clienteveh",vc);
       model.addAttribute("Exito",mensaje);
	return "venta/consultaVenta";
    }
    
   
    //================================================================
    
       @RequestMapping("/venta/busquedaC")
      
	public ModelAndView busquedaVehiculo(@RequestParam("marca") String marca ,@RequestParam("modelo") String modelo,@RequestParam("desde") Integer desde,@RequestParam("hasta") Integer hasta,HttpSession session,Model model){
        Usuario u = nomUsuario.obtenerUsuario(session);
        List<VentasCliente> veh= new  ArrayList<VentasCliente>();
        List<Marca> marcas=(List<Marca>) marcadao.findAll();
        List<Modelo> modelos=(List<Modelo>) modelodao.findAll();
         if(marca.equals("0")&&modelo.equals("0")){
          veh=vcdao.findByAniosBetweenAndIdusuario(desde, hasta,u.getIdusuario());
          }else{
            if(!marca.equals("0")&&modelo.equals("0")){
                veh=vcdao.findByAniosBetweenAndNommarcaAndIdusuario(marca, desde, hasta,u.getIdusuario());
            }else{
                if(marca.equals("0")&&!modelo.equals("0")){
                    veh=vcdao.findByAniosBetweenAndNommodeloAndIdusuario(modelo, desde, hasta,u.getIdusuario());
                }
                else{
                    veh=vcdao.findByAniosBetweenAndNommarcaAndNommodeloAndIdusuario(marca, modelo, desde, hasta,u.getIdusuario());
                }
            }
          }
              
           
          return new ModelAndView("/venta/consultaVenta").addObject("usuario",u).addObject("modelo",modelos).addObject("clienteveh",veh).addObject("marcas",marcas);
    }    
     
        
         @RequestMapping(value = "/entregarvehiculo")
    public ModelAndView guardarSolicitud(@RequestParam("ventas[]") Integer[] ventas,HttpSession session) {
        Usuario u = nomUsuario.obtenerUsuario(session);
           for(int i=0; i<ventas.length; i++){
                clienteveh.updateEntregado(ventas[i]);
            }
        String mensaje = "Solicitud Realizada con Exito!!!";
        ModelAndView vista = new ModelAndView();
        vista.setViewName("/venta/entregarVehiculo");
        vista.addObject("usuario", u);
        vista.addObject("mensaje", mensaje);
        return vista;
        
    }
   
        
}
