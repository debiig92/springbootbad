/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Espacio_Bodega;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Azucena
 */
public interface Vehiculo_Espacio_BodegaDAO extends CrudRepository<Vehiculo_Espacio_Bodega, Integer>{
    @Query("SELECT  p.idespa From Vehiculo_Espacio_Bodega p WHERE p.idvehiculo =:id")
    public int verIdEspa(@Param("id") int id);
    
    @Query("SELECT  p From Vehiculo_Espacio_Bodega p WHERE p.idpiso =:id")
    public List<Vehiculo_Espacio_Bodega> verEspacioPiso(@Param("id") int id);
}
