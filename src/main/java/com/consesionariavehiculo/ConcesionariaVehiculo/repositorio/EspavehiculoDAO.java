/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Espavehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Piso;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Azucena
 */
public interface EspavehiculoDAO extends CrudRepository<Espavehiculo, Integer> {

    @Query("SELECT  p From Espavehiculo p WHERE p.idpiso =:id and p.ocupado =0")
    public List<Espavehiculo> espaPisos(@Param("id") Piso id);

    /*   
    @Query("SELECT  p From Espavehiculo p WHERE p.espa =:id")
    public List<Espavehiculo> idPiso(@Param("id") Espavehiculo id);
     */
    @Modifying
    @Transactional
    @Query("update Espavehiculo p set p.ocupado=1 where p.idespa=:id")
    public void updateOcupado(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("update Espavehiculo p set p.ocupado=0 where p.idespa=:id")
    public void updateDesocupado(@Param("id") int id);
}
