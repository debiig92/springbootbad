/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.Imagenes;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodega;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Marca;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Modelo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.BodegaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ImportadorDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.InventarioDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.MarcaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ModeloDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Inventario;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class InventarioController {
    Importador i= new Importador();
    Usuario usuario;
    @Autowired
    private ImportadorDAO importador;
    @Autowired
    private InventarioDAO inventario;
    @Autowired
      private MarcaDAO marcadao;
      @Autowired
      private ModeloDAO modelodao;
      @Autowired
      private BodegaDAO bodegadao;
       General nomUsuario= new General();
    @RequestMapping("/inventario")
	public ModelAndView obtenerImportacion(HttpSession session) {
        Usuario u = obtenerUsuario(session); 
       List<Marca> marcas=(List<Marca>) marcadao.findAll();
       List<Modelo> modelo=(List<Modelo>) modelodao.findAll();
       List<Bodega> bodega=(List<Bodega>) bodegadao.findAll();
       if(u.getIdrol()==3){
        i= obtenerImportadorByUsuario(u);
        List<Inventario> in= (List<Inventario>)inventario.findBynit(i.getNit());
         return new ModelAndView("inventario/busquedaInventario").addObject("usuario",u).addObject("importador",i)
               .addObject("inventario",in).addObject("modelo",modelo).addObject("lista1",marcas).addObject("bodega",bodega);
       }
       else{
       List<Inventario> in= (List<Inventario>)inventario.findAll();
        return new ModelAndView("inventario/busquedaInventario").addObject("usuario",u)
               .addObject("inventario",in).addObject("modelo",modelo).addObject("lista1",marcas).addObject("bodega",bodega);
       }
      
	}
        
        
        
         @RequestMapping("/inventario/busqueda")
       @ResponseBody
	public ModelAndView busquedaVehiculo(@RequestParam("marca") Integer marca ,@RequestParam("modelo") Integer modelo,@RequestParam("bodega") Integer bod,@RequestParam("estado") Integer estado,@RequestParam("desde") Integer desde,@RequestParam("hasta") Integer hasta,HttpSession session){
        List<Inventario> veh= new  ArrayList<Inventario>();
         List<Marca> marcas=(List<Marca>) marcadao.findAll();
        List<Modelo> modelos=(List<Modelo>) modelodao.findAll();
         List<Bodega> bodega=(List<Bodega>) bodegadao.findAll();
         Usuario u = nomUsuario.obtenerUsuario(session);
        if(u.getIdrol()==3){
         i= obtenerImportadorByUsuario(u);
         if(marca==0&&modelo==0&&bod==0&&estado==0){
          veh=inventario.findByAniosBetweenAndNit(desde, hasta,i.getNit());
          }else{
            if(marca!=0&&modelo==0&&bod==0&&estado==0){
                veh=inventario.findByAniosBetweenAndIdmarcaAndNit(marca, desde, hasta,i.getNit());
            }else{
                if(marca==0&&modelo!=0&&bod==0&&estado==0){
                    veh=inventario.findByAniosBetweenAndIdmodeloAndNit(modelo, desde, hasta,i.getNit());
                }
                else{
                   if(marca==0&&modelo==0&&bod!=0&&estado==0){
                       veh=inventario.findByAniosBetweenAndIdbodegaAndNit(desde, hasta, bod,i.getNit());
                   }else{
                       if(marca==0&&modelo==0&&bod==0&&estado!=0){
                            veh=inventario.findByAniosBetweenAndIdestadoAndNit(desde, hasta, estado,i.getNit());
                       }
                       else{
                           if(marca!=0&&modelo!=0&&bod==0&&estado==0){
                               veh=inventario.findByAniosBetweenAndIdmarcaAndIdmodeloAndNit(marca,modelo,desde,hasta,i.getNit());
                           }else{
                               if(marca!=0&&modelo==0&&bod!=0&&estado==0){
                               veh=inventario.findByAniosBetweenAndIdmarcaAndIdbodegaAndNit(marca, desde, hasta, bod,i.getNit());
                              }else{
                                   if(marca!=0&&modelo==0&&bod==0&&estado!=0){
                                     veh=inventario.findByAniosBetweenAndIdmarcaAndIdestadoAndNit(marca, desde, hasta, estado,i.getNit());
                                   }else{
                                       if(marca==0&&modelo!=0&&bod!=0&&estado==0){
                                        veh=inventario.findByAniosBetweenAndIdmodeloAndIdbodegaAndNit(modelo,desde,hasta,bod,i.getNit());
                                        }else{
                                            if(marca==0&&modelo!=0&&bod==0&&estado!=0){
                                            veh=inventario.findByAniosBetweenAndIdmodeloAndIdestadoAndNit(modelo, desde, hasta, estado,i.getNit());
                                            }else{
                                                if(marca==0&&modelo==0&&bod!=0&&estado!=0){
                                                   veh=inventario.findByAniosBetweenAndIdbodegaAndIdestadoAndNit(desde, hasta, bod, estado,i.getNit());
                                                }else{
                                                    veh=inventario.findByAniosBetweenAndIdmarcaAndIdmodeloAndIdbodegaAndIdestadoAndNit(marca, modelo, desde, hasta, estado, bod,i.getNit());
                                                }
                                            }
                                        }
                                   }
                               }
                           }
                       }
                   }
                }
            }
          }
    
           
          return new ModelAndView("/inventario/busquedaInventario").addObject("modelo",modelos).addObject("lista1",marcas).addObject("inventario",veh).addObject("usuario",u).addObject("bodega",bodega);
        }else{
        
        
          if(marca==0&&modelo==0&&bod==0&&estado==0){
          veh=inventario.findByAniosBetween(desde, hasta);
          }else{
            if(marca!=0&&modelo==0&&bod==0&&estado==0){
                veh=inventario.findByAniosBetweenAndIdmarca(marca, desde, hasta);
            }else{
                if(marca==0&&modelo!=0&&bod==0&&estado==0){
                    veh=inventario.findByAniosBetweenAndIdmodelo(modelo, desde, hasta);
                }
                else{
                   if(marca==0&&modelo==0&&bod!=0&&estado==0){
                       veh=inventario.findByAniosBetweenAndIdbodega(desde, hasta, bod);
                   }else{
                       if(marca==0&&modelo==0&&bod==0&&estado!=0){
                            veh=inventario.findByAniosBetweenAndIdestado(desde, hasta, estado);
                       }
                       else{
                           if(marca!=0&&modelo!=0&&bod==0&&estado==0){
                               veh=inventario.findByAniosBetweenAndIdmarcaAndIdmodelo(marca,modelo,desde,hasta);
                           }else{
                               if(marca!=0&&modelo==0&&bod!=0&&estado==0){
                               veh=inventario.findByAniosBetweenAndIdmarcaAndIdbodega(marca, desde, hasta, bod);
                              }else{
                                   if(marca!=0&&modelo==0&&bod==0&&estado!=0){
                                     veh=inventario.findByAniosBetweenAndIdmarcaAndIdestado(marca, desde, hasta, estado);
                                   }else{
                                       if(marca==0&&modelo!=0&&bod!=0&&estado==0){
                                        veh=inventario.findByAniosBetweenAndIdmodeloAndIdbodega(modelo,desde,hasta,bod);
                                        }else{
                                            if(marca==0&&modelo!=0&&bod==0&&estado!=0){
                                            veh=inventario.findByAniosBetweenAndIdmodeloAndIdestado(modelo, desde, hasta, estado);
                                            }else{
                                                if(marca==0&&modelo==0&&bod!=0&&estado!=0){
                                                   veh=inventario.findByAniosBetweenAndIdbodegaAndIdestado(desde, hasta, bod, estado);
                                                }else{
                                                    veh=inventario.findByAniosBetweenAndIdmarcaAndIdmodeloAndIdbodegaAndIdestado(marca, modelo, desde, hasta, estado, bod);
                                                }
                                            }
                                        }
                                   }
                               }
                           }
                       }
                   }
                }
            }
          }
    
           
          return new ModelAndView("/inventario/busquedaInventario").addObject("modelo",modelos).addObject("lista1",marcas).addObject("inventario",veh).addObject("usuario",u).addObject("bodega",bodega);
        
        
        
        }
        
        
        
        
        } 
        
        
        
        
          //ejemplo json 
    @RequestMapping(value = "/leerCombo3/", method = RequestMethod.POST)
    public String leerCombo2(@RequestParam(value = "id") Marca id,Model model) {
        List<Modelo> combo2 = (List<Modelo>) modelodao.modeloDep(id);
        model.addAttribute("itemList", combo2);
        return "/inventario/busquedaInventario::#item";
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
