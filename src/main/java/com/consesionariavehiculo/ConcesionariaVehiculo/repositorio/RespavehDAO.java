/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Respaveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Azucena
 */
public interface RespavehDAO extends CrudRepository<Respaveh, Integer>{
    @Modifying
    @Transactional
    @Query("delete from Respaveh u where u.idvehiculo =:idvehiculo")
    void deleteRespavehByIdvehiculo( @Param("idvehiculo") Vehiculo idvehiculo);
}
