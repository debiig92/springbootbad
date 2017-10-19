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
public class Vehiculo_Saltaller implements Serializable{

    /**
     * @return the idvehtaller
     */
    @Id
    public int getIdvehtaller() {
        return idvehtaller;
    }

    /**
     * @param idvehtaller the idvehtaller to set
     */
    public void setIdvehtaller(int idvehtaller) {
        this.idvehtaller = idvehtaller;
    }

    /**
     * @return the idsaltaller
     */
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
     * @return the idimport
     */
    public int getIdimport() {
        return idimport;
    }

    /**
     * @param idimport the idimport to set
     */
    public void setIdimport(int idimport) {
        this.idimport = idimport;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the fecimport
     */
    public String getFecimport() {
        return fecimport;
    }

    /**
     * @param fecimport the fecimport to set
     */
    public void setFecimport(String fecimport) {
        this.fecimport = fecimport;
    }

    /**
     * @return the nomimp
     */
    public String getNomimp() {
        return nomimp;
    }

    /**
     * @param nomimp the nomimp to set
     */
    public void setNomimp(String nomimp) {
        this.nomimp = nomimp;
    }

    /**
     * @return the apeimp
     */
    public String getApeimp() {
        return apeimp;
    }

    /**
     * @param apeimp the apeimp to set
     */
    public void setApeimp(String apeimp) {
        this.apeimp = apeimp;
    }

    /**
     * @return the dirimp
     */
    public String getDirimp() {
        return dirimp;
    }

    /**
     * @param dirimp the dirimp to set
     */
    public void setDirimp(String dirimp) {
        this.dirimp = dirimp;
    }

    /**
     * @return the telresp
     */
    public String getTelresp() {
        return telresp;
    }

    /**
     * @param telresp the telresp to set
     */
    public void setTelresp(String telresp) {
        this.telresp = telresp;
    }
    private int idvehtaller;
    private int idsaltaller;
    private int idvehiculo;
    private int idimport;
    private String nit;
    private String fecimport;
    private String nomimp;
    private String apeimp;
    private String dirimp;
    private String telresp;
}
