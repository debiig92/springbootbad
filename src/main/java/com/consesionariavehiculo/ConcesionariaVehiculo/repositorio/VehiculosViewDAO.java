/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Humberto
 */
@Repository
public interface VehiculosViewDAO extends CrudRepository<Vehiculos,Integer>{
      List<Vehiculos> findByidimport(int nit);
       List<Vehiculos> findTop6Byidestado(int idestado);
       List<Vehiculos> findByidestado(int idestado);
}
