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
public class Vehiculo_Taller implements Serializable{

    /**
     * @return the idsaltaller
     */
    @Id
    public int getIdsaltaller() {
        return idsaltaller;
    }

    /**
     * @param idsaltaller the idsaltaller to set
     */
    public void setIdsaltaller(int idsaltaller) {
        this.idsaltaller = idsaltaller;
    }

    /**
     * @return the idtaller
     */
    public int getIdtaller() {
        return idtaller;
    }

    /**
     * @param idtaller the idtaller to set
     */
    public void setIdtaller(int idtaller) {
        this.idtaller = idtaller;
    }

    /**
     * @return the duimotorista
     */
    public String getDuimotorista() {
        return duimotorista;
    }

    /**
     * @param duimotorista the duimotorista to set
     */
    public void setDuimotorista(String duimotorista) {
        this.duimotorista = duimotorista;
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

    /**
     * @return the fechaingtaller
     */
    public String getFechaingtaller() {
        return fechaingtaller;
    }

    /**
     * @param fechaingtaller the fechaingtaller to set
     */
    public void setFechaingtaller(String fechaingtaller) {
        this.fechaingtaller = fechaingtaller;
    }

    /**
     * @return the nomtaller
     */
    public String getNomtaller() {
        return nomtaller;
    }

    /**
     * @param nomtaller the nomtaller to set
     */
    public void setNomtaller(String nomtaller) {
        this.nomtaller = nomtaller;
    }

    /**
     * @return the dirtaller
     */
    public String getDirtaller() {
        return dirtaller;
    }

    /**
     * @param dirtaller the dirtaller to set
     */
    public void setDirtaller(String dirtaller) {
        this.dirtaller = dirtaller;
    }
    private int idsaltaller;
    private int idtaller;
    private String duimotorista;
    private String placarem;
    private String fechaingtaller;
    private String nomtaller;
    private String dirtaller;    
}
