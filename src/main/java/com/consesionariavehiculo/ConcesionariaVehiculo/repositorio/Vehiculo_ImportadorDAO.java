/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Importador;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Azucena
 */
public interface Vehiculo_ImportadorDAO extends CrudRepository<Vehiculo_Importador, Integer> {
    
}