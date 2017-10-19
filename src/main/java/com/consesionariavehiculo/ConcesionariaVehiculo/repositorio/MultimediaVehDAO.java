/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Multimediaveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Tipomultimedia;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author user
 */
@Transactional 
public interface MultimediaVehDAO extends CrudRepository<Multimediaveh,Integer>{
    List<Multimediaveh> findByidvehiculoAndIdtipomultimedia(Vehiculo idvehiculo,Tipomultimedia tipo);
   // Multimediaveh findByidvehiculo(Vehiculo idvehiculo);
}
