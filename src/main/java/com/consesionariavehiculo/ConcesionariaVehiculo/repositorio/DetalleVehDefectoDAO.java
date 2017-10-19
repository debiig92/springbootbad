/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Detallevehdef;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface DetalleVehDefectoDAO extends CrudRepository<Detallevehdef,Integer>{
    @Modifying
    @Transactional
    @Query("update Detallevehdef p set p.reparado=1 where p.iddetveh=:iddetveh")
    public void updateReparado(@Param("iddetveh") Integer iddetveh);
}
