/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import javax.transaction.Transactional;

/**
 *
 * @author daniel
 */
@Transactional 
public interface UsuarioRepo  extends CrudRepository<Usuario, Integer>{
    public Usuario findFirstByNomusuario(String nombre);
}
