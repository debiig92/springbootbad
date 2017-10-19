/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import javax.transaction.Transactional;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Taller;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author carlos
 */
@Transactional 
public interface TallerRepo extends CrudRepository<Taller,Integer>{
    
}
