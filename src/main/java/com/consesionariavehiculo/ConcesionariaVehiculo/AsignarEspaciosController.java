/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodega;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Estado;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.BodegaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class AsignarEspaciosController {
     @Autowired
      private BodegaDAO bodegadao;
      @Autowired
      private VehiculoDAO vehiculodao;
       General nomUsuario= new General();
    @RequestMapping("/espacios/busqueda")
	public ModelAndView asignar(HttpSession session) {
                Estado e= new Estado();
                  Usuario u = nomUsuario.obtenerUsuario(session);
                e.setIdestado(6);
                 List<Bodega> bodega=(List<Bodega>) bodegadao.findAll();
                 List<Vehiculo> vehiculos= vehiculodao.findByidestado(e);
	return new ModelAndView("espacios/asignarEspacios").addObject("usuario",u).addObject("bodega",bodega).addObject("vehiculos",vehiculos);
	}
}
