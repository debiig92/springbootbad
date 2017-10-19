/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.repositorio;

import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Inventario;
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
public interface InventarioDAO extends CrudRepository<Inventario,Integer>{
     List<Inventario> findBynit(String nit);  
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmarcaAndNit(@Param("idmarca") Integer idmarca,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("nit") String nit);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmodeloAndNit(@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta ,@Param("nit") String nit);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.idmarca =:idmarca AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdmodeloAndNit(@Param("idmarca") Integer idmarca, @Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta ,@Param("nit") String nit);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndNit(@Param("desde")Integer desde,@Param("hasta")Integer hasta ,@Param("nit") String nit);
     
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idestado=:idestado AND e.idmodelo =:idmodelo AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdestadoAndIdmarcaAndIdmodeloAndNit(@Param("idmarca") Integer idmarca,@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado ,@Param("nit") String nit);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idestado=:idestado AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdestadoAndNit(@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado ,@Param("nit") String nit);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idestado=:idestado AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdestadoAndNit(@Param("idmarca") Integer idmarca,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado ,@Param("nit") String nit);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.idestado=:idestado AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmodeloAndIdestadoAndNit(@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado ,@Param("nit") String nit);

     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idbodega=:idbodega AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdbodegaAndNit(@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega ,@Param("nit") String nit);
     
     
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idmodelo =:idmodelo AND e.idbodega=:idbodega AND e.idestado=:idestado AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdmodeloAndIdbodegaAndIdestadoAndNit(@Param("idmarca") Integer idmarca,@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado,@Param("idbodega")Integer idbodega,@Param("nit") String nit);
     
     
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idbodega=:idbodega AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdbodegaAndNit(@Param("idmarca") Integer idmarca,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega,@Param("nit") String nit);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.idbodega=:idbodega AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdmodeloAndIdbodegaAndNit(@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega,@Param("nit") String nit);

       @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idbodega=:idbodega AND e.idestado=:idestado AND e.nit = :nit")
     List<Inventario> findByAniosBetweenAndIdbodegaAndIdestadoAndNit(@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega,@Param("idestado")Integer idestado,@Param("nit") String nit);

     
     //============================================SIN NIT=================================================================
     
      @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca")
     List<Inventario> findByAniosBetweenAndIdmarca(@Param("idmarca") Integer idmarca,@Param("desde")Integer desde,@Param("hasta")Integer hasta);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo")
     List<Inventario> findByAniosBetweenAndIdmodelo(@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta );
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.idmarca =:idmarca")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdmodelo(@Param("idmarca") Integer idmarca, @Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta")
     List<Inventario> findByAniosBetween(@Param("desde")Integer desde,@Param("hasta")Integer hasta);
     
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idestado=:idestado AND e.idmodelo =:idmodelo")
     List<Inventario> findByAniosBetweenAndIdestadoAndIdmarcaAndIdmodelo(@Param("idmarca") Integer idmarca,@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado );
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idestado=:idestado")
     List<Inventario> findByAniosBetweenAndIdestado(@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idestado=:idestado")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdestado(@Param("idmarca") Integer idmarca,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.idestado=:idestado")
     List<Inventario> findByAniosBetweenAndIdmodeloAndIdestado(@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado);

     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idbodega=:idbodega")
     List<Inventario> findByAniosBetweenAndIdbodega(@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega);
     
     
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idmodelo =:idmodelo AND e.idbodega=:idbodega AND e.idestado=:idestado")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdmodeloAndIdbodegaAndIdestado(@Param("idmarca") Integer idmarca,@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idestado")Integer idestado,@Param("idbodega")Integer idbodega);
     
     
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmarca =:idmarca AND e.idbodega=:idbodega")
     List<Inventario> findByAniosBetweenAndIdmarcaAndIdbodega(@Param("idmarca") Integer idmarca,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega);
     @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idmodelo =:idmodelo AND e.idbodega=:idbodega")
     List<Inventario> findByAniosBetweenAndIdmodeloAndIdbodega(@Param("idmodelo") Integer idmodelo,@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega);

       @Query("SELECT e FROM Inventario e WHERE e.anio BETWEEN :desde AND :hasta AND e.idbodega=:idbodega AND e.idestado=:idestado")
     List<Inventario> findByAniosBetweenAndIdbodegaAndIdestado(@Param("desde")Integer desde,@Param("hasta")Integer hasta,@Param("idbodega")Integer idbodega,@Param("idestado")Integer idestado);

     
     
}
