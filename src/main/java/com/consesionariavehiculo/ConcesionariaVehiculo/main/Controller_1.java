/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.main;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





/**
 *
 * @author Humberto
 */
@Controller
@RequestMapping("/")
public class Controller_1 {
    
        
    public String vista(){
    return "Vista1";
    }
    
}
