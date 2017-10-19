/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Imagenveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Multimediaveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Tipomultimedia;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Humberto
 */
@Repository
public interface ImagenVehDAO extends CrudRepository<Imagenveh,Integer>{
    List<Imagenveh> findByidvehiculoAndIdtipomultimedia(Vehiculo idvehiculo,Tipomultimedia tipo); 
}
