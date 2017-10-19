/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Importaciones;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Humberto
 */
@Repository
public interface ImportacionesViewDAO extends CrudRepository<Importaciones,Integer>{
    List<Importaciones> findBynit(String nit);
}
