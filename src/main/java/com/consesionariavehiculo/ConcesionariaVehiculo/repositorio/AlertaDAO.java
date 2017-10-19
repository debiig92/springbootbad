/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Alerta;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Humberto
 */
@Repository
public interface AlertaDAO extends CrudRepository<Alerta,Integer>{
    List<Alerta> findByIdusuarioAndActivo(Usuario idusuario,Integer activo);
    Integer countByidusuarioAndActivo(Usuario idusuario,Integer activo);
}
