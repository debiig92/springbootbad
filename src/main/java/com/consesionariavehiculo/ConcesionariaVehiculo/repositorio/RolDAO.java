/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rol;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author daniel
 */
public interface RolDAO extends CrudRepository<Rol, Integer>{
   public Rol findFirstByNomrol(String nombre);
}
