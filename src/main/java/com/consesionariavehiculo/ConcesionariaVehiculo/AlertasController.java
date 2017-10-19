/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.General;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Alerta;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.AlertaDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Humberto
 */
@Controller
public class AlertasController {
    General nomUsuario= new General();
    @Autowired
    private AlertaDAO alerta;
    @RequestMapping("/alertas")
    public ModelAndView obtenerImportacion(HttpSession session) {
            Usuario u = nomUsuario.obtenerUsuario(session);
            List<Alerta> alert=alerta.findByIdusuarioAndActivo(u,1);
            return new ModelAndView("alertas/alertas").addObject("usuario",u).addObject("alertas",alert);
	}
    
    @RequestMapping("/eliminarAlerta/{idalerta}")
    public ModelAndView eliminarAlerta(@PathVariable int idalerta,HttpSession session) {
            Usuario u = nomUsuario.obtenerUsuario(session);
            Alerta a= new Alerta();
            a.setIdalerta(idalerta);
            alerta.delete(a);
            a=null;
            return new ModelAndView("alertas/alertas").addObject("usuario",u).addObject("alertas",a);
	}
    
}
