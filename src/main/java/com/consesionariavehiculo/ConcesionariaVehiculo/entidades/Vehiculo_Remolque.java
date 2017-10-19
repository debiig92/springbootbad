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
public class Vehiculo_Remolque implements Serializable{

    /**
     * @return the idtipovehrem
     */
    public int getIdtipovehrem() {
        return idtipovehrem;
    }

    /**
     * @param idtipovehrem the idtipovehrem to set
     */
    public void setIdtipovehrem(int idtipovehrem) {
        this.idtipovehrem = idtipovehrem;
    }

    /**
     * @return the maxvehrem
     */
    public int getMaxvehrem() {
        return maxvehrem;
    }

    /**
     * @param maxvehrem the maxvehrem to set
     */
    public void setMaxvehrem(int maxvehrem) {
        this.maxvehrem = maxvehrem;
    }

    /**
     * @return the nomtiporem
     */
    public String getNomtiporem() {
        return nomtiporem;
    }

    /**
     * @param nomtiporem the nomtiporem to set
     */
    public void setNomtiporem(String nomtiporem) {
        this.nomtiporem = nomtiporem;
    }

    /**
     * @return the placarem
     */
    public String getPlacarem() {
        return placarem;
    }

    /**
     * @param placarem the placarem to set
     */
    public void setPlacarem(String placarem) {
        this.placarem = placarem;
    }
    @Id
    private int idtipovehrem;
    private int maxvehrem;
    private String nomtiporem;
    private String placarem;
    
}
