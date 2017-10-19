/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Marca;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Modelo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Humberto
 */
@Transactional 
public interface ModeloDAO extends CrudRepository<Modelo,Integer>{
 @Query("SELECT  p From Modelo p WHERE p.idmarca =:id")
    public List<Modelo> modeloDep(@Param("id") Marca id);
   List<Modelo> findByidmarca(String idmarca);
}
