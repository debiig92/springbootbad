/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculosventa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author user
 */
public interface VehiculosVentaDAO extends CrudRepository<Vehiculosventa,Integer>{
      List<Vehiculosventa> findByidimport(int nit);
       List<Vehiculosventa> findTop6Byidestado(int idestado);
       List<Vehiculosventa> findByidestado(int idestado);
}

