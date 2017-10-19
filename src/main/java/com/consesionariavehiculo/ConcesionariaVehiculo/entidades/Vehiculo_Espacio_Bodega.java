/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Azucena
 */
@Entity
public class Vehiculo_Espacio_Bodega implements Serializable {

    /**
     * @return the idespa
     */
    @Id
    public int getIdespa() {
        return idespa;
    }

    /**
     * @param idespa the idespa to set
     */
    public void setIdespa(int idespa) {
        this.idespa = idespa;
    }

    /**
     * @return the idpiso
     */
    public int getIdpiso() {
        return idpiso;
    }

    /**
     * @param idpiso the idpiso to set
     */
    public void setIdpiso(int idpiso) {
        this.idpiso = idpiso;
    }

    /**
     * @return the numespa
     */
    public int getNumespa() {
        return numespa;
    }

    /**
     * @param numespa the numespa to set
     */
    public void setNumespa(int numespa) {
        this.numespa = numespa;
    }

    /**
     * @return the idvehiculo
     */
    public int getIdvehiculo() {
        return idvehiculo;
    }

    /**
     * @param idvehiculo the idvehiculo to set
     */
    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    /**
     * @return the idestado
     */
    public int getIdestado() {
        return idestado;
    }

    /**
     * @param idestado the idestado to set
     */
    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    /**
     * @return the numpiso
     */
    public int getNumpiso() {
        return numpiso;
    }

    /**
     * @param numpiso the numpiso to set
     */
    public void setNumpiso(int numpiso) {
        this.numpiso = numpiso;
    }

    /**
     * @return the idmodelo
     */
    public int getIdmodelo() {
        return idmodelo;
    }

    /**
     * @param idmodelo the idmodelo to set
     */
    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }

    /**
     * @return the idmarca
     */
    public int getIdmarca() {
        return idmarca;
    }

    /**
     * @param idmarca the idmarca to set
     */
    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    /**
     * @return the nommarca
     */
    public String getNommarca() {
        return nommarca;
    }

    /**
     * @param nommarca the nommarca to set
     */
    public void setNommarca(String nommarca) {
        this.nommarca = nommarca;
    }

    /**
     * @return the detalledef
     */
    public String getDetalledef() {
        return detalledef;
    }

    /**
     * @param detalledef the detalledef to set
     */
    public void setDetalledef(String detalledef) {
        this.detalledef = detalledef;
    }

    /**
     * @return the dirbodega
     */
    public String getDirbodega() {
        return dirbodega;
    }

    /**
     * @param dirbodega the dirbodega to set
     */
    public void setDirbodega(String dirbodega) {
        this.dirbodega = dirbodega;
    }
    private int idespa;
    private int idpiso;
    private int numespa;
    private int idvehiculo;
    private int idestado;    
    private int numpiso;    
    private int idmodelo;    
    private int idmarca;    
    private String nommarca;    
    private String detalledef;    
    private String dirbodega;    
}
