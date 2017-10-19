/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;


import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface UsuarioDAO extends CrudRepository<Usuario,Long>{
    Usuario findBynomusuarioAndPassusuario(String nomusuario, String passusuario);
}
