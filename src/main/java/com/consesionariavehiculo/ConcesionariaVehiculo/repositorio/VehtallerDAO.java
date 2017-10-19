/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehtaller;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Azucena
 */
public interface VehtallerDAO extends CrudRepository<Vehtaller, Integer> {
     @Modifying
    @Transactional
    @Query("update Vehtaller p set p.costotall=:costotall where p.idvehtaller=:idvehtaller")
    public void updateCostoTaller(@Param("costotall") Integer costotall,@Param("idvehtaller") Integer idvehtaller);
    
    
    
    @Modifying
    @Transactional
    @Query("update Vehtaller p set p.costotall=:costotall where p.costotall is null and p.idvehiculo=:idvehiculo")
    public void updateCostoTaller2(@Param("costotall") Integer costotall,@Param("idvehiculo") Integer idvehiculo);
}
