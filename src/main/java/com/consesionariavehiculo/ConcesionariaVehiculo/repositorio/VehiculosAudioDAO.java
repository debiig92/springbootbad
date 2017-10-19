/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VehiculosAudio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Humberto
 */
@Transactional
public interface VehiculosAudioDAO extends CrudRepository<VehiculosAudio,Integer>{
      List<VehiculosAudio> findByidvehiculo(Integer idvehiculo);
}
