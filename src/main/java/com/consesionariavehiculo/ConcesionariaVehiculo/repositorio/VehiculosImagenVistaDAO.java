/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VehiculosImagen;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
@Transactional 
public interface VehiculosImagenVistaDAO  extends CrudRepository<VehiculosImagen,Integer>{
    List<VehiculosImagen> findTop6Byidestado(int idestado);
   @Query("SELECT e FROM VehiculosImagen e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca")
     List<VehiculosImagen> findByAniosBetweenAndIdmarca(@Param("idmarca") Integer idmarca,@Param("desde")Integer desde,@Param("hasta")Integer hasta);
     @Query("SELECT e FROM VehiculosImagen e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo")
     List<VehiculosImagen> findByAniosBetweenAndIdmodelo(@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta);
     @Query("SELECT e FROM VehiculosImagen e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.idmarca =:idmarca")
     List<VehiculosImagen> findByAniosBetweenAndIdmarcaAndIdmodelo(@Param("idmarca") Integer idmarca, @Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta);
     @Query("SELECT e FROM VehiculosImagen e WHERE e.anio BETWEEN :desde AND :hasta")
     List<VehiculosImagen> findByAniosBetween(@Param("desde")Integer desde,@Param("hasta")Integer hasta);
}
