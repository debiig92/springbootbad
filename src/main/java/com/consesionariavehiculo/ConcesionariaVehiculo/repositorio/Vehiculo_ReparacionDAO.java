/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Reparacion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Azucena
 */
public interface Vehiculo_ReparacionDAO extends CrudRepository<Vehiculo_Reparacion, Integer>{
    @Query("SELECT  v From Vehiculo_Reparacion v WHERE v.idestado =:id ")
    public List<Vehiculo_Reparacion> vehiculoRep(@Param("id") int id);
}
