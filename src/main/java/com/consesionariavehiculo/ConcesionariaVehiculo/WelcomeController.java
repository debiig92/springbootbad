/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

/**
 *
 * @author user
 */
import com.consesionariavehiculo.ConcesionariaVehiculo.Seguridad.Imagenes;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosImagenVistaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculos;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VehiculosImagen;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.persistence.internal.oxm.conversion.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    // inject via application.properties
	@Autowired
        private VehiculosImagenVistaDAO vistaVehiculo;

	@RequestMapping("/")
	public String welcome(Model model) {
               
		List<VehiculosImagen> v=(List<VehiculosImagen>) vistaVehiculo.findTop6Byidestado(3);
                List<Imagenes> im = new ArrayList<Imagenes>();
                 for(VehiculosImagen f : v) {
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
                    im.add(ima);
             }
                model.addAttribute("vehiculos", im);
		return "index";
	}
        @RequestMapping("/login")
	public String login() {
		
		return "login";
	}
        
        @RequestMapping("/panel")
	public String panelAdmin() {
		
		return "plantilla/header2";
	}

}
