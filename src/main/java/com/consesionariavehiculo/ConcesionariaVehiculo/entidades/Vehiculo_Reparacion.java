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
public class Vehiculo_Reparacion implements Serializable{

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
     * @return the nomestado
     */
    public String getNomestado() {
        return nomestado;
    }

    /**
     * @param nomestado the nomestado to set
     */
    public void setNomestado(String nomestado) {
        this.nomestado = nomestado;
    }

    /**
     * @return the nommodel
     */
    public String getNommodel() {
        return nommodel;
    }

    /**
     * @param nommodel the nommodel to set
     */
    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }

private int idvehiculo;

private String nomestado;

private String nommodel;

private String detalledef;

private int idestado;
@Id
private int iddetveh;

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

    public int getIddetveh() {
        return iddetveh;
    }

    public void setIddetveh(int iddetveh) {
        this.iddetveh = iddetveh;
    }
    
    
}
