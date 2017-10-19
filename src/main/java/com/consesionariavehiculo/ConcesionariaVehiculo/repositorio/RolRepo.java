/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rol;

/**
 *
 * @author daniel
 */
@Transactional 
public interface RolRepo  extends CrudRepository<Rol,Integer>{
    public Rol findFirstByNomrol(String nombre);
}
