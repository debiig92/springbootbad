/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Saltaller;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Azucena
 */
public interface Vehiculo_SaltallerDAO extends CrudRepository<Vehiculo_Saltaller, Integer> {
    @Query("SELECT  vs From Vehiculo_Saltaller vs WHERE vs.idsaltaller =:id")
    public List<Vehiculo_Saltaller> findvsByName(@Param("id") int id);
    
}
