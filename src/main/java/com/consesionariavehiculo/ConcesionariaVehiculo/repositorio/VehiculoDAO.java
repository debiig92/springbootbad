/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Estado;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Humberto
 */
@Transactional 
public interface VehiculoDAO extends CrudRepository<Vehiculo,Integer>{
    List<Vehiculo> findByidimport(Importacion idimport);
    List<Vehiculo> findByidimportAndIdestado(Importacion idimport,Estado idestado);
    List<Vehiculo> findByidestado(Estado idestado);
    @Modifying
    @Query("update Vehiculo p set p.idestado=6 where p.idvehiculo=:idvehiculo")
    public void updateIdestado(@Param("idvehiculo") Integer idvehiculo);
  }
