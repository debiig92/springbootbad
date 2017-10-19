/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

/**
 *
 * @author user
 */


import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Entsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rentsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentsalvehDAO extends CrudRepository<Rentsalveh,Integer>{
   @Query("SELECT  p.idvehiculo From  Rentsalveh p WHERE p.identsalveh =:identsalveh")
    List<Vehiculo> findByidentsalveh(@Param("identsalveh") Entsalveh identsalveh);
}
