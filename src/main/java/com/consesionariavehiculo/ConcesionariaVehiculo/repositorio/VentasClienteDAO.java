/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.VentasCliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Humberto
 */
@Repository
public interface VentasClienteDAO extends CrudRepository<VentasCliente,Integer>{
    List<VentasCliente> findByidusuario(Integer idusuario);
    @Query("SELECT e FROM VentasCliente e WHERE e.anio BETWEEN :desde AND :hasta AND e.nommarca =:nommarca AND e.idusuario =:idusuario")
     List<VentasCliente> findByAniosBetweenAndNommarcaAndIdusuario(@Param("nommarca") String nommarcas,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idusuario")Integer idusuario);
     @Query("SELECT e FROM VentasCliente e WHERE e.anio BETWEEN :desde AND :hasta AND e.nommodelo =:nommodelo AND e.idusuario =:idusuario")
     List<VentasCliente> findByAniosBetweenAndNommodeloAndIdusuario(@Param("nommodelo") String nommodel,@Param("desde")Integer desde,@Param("hasta")Integer hasta ,@Param("idusuario")Integer idusuario);
     @Query("SELECT e FROM VentasCliente e WHERE e.anio BETWEEN :desde AND :hasta AND e.nommodelo =:nommodelo AND e.nommarca =:nommarca AND e.idusuario =:idusuario")
     List<VentasCliente> findByAniosBetweenAndNommarcaAndNommodeloAndIdusuario(@Param("nommarca") String nommarca, @Param("nommodelo") String nommodel,@Param("desde")Integer desde,@Param("hasta")Integer hasta ,@Param("idusuario")Integer idusuario);
     @Query("SELECT e FROM VentasCliente e WHERE e.anio BETWEEN :desde AND :hasta AND e.idusuario =:idusuario ")
     List<VentasCliente> findByAniosBetweenAndIdusuario(@Param("desde")Integer desde,@Param("hasta")Integer hasta ,@Param("idusuario")Integer idusuario);
     
     List<VentasCliente> findByentregado(Integer entregado);
     
}
