/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Humberto
 */
@Repository
//@Transactional 
public interface ImportadorDAO extends CrudRepository<Importador,String>{
  @Query("select e from Importador e join fetch e.usuario u where u.idusuario = :idusuario")
          // @Query("SELECT c FROM Importador c JOIN c.capital p")
 // Importador findByUsuario(@Param("idusuario")String idusuario);
   Importador findByUsuario(@Param("idusuario") Integer idusuario); 
   Importador findFirstByNit(String nit);
   Integer removeByNit(String nit);
}
