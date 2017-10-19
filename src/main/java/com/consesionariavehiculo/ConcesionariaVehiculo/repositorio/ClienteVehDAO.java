/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Clienteveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Humberto
 */
@Repository
public interface ClienteVehDAO extends CrudRepository<Clienteveh,Integer>{
    List<Clienteveh> findByidusuario(Usuario idusuario);
    
    
     @Modifying
     @Transactional 
     @Query("update Clienteveh p set p.entregado=1 where p.idclienteveh =:idclienteveh")
     public void updateEntregado(@Param("idclienteveh") Integer idclienteveh);
}
