/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.vistas;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "espaciosdetalle")
public class EspaciosDetalle implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVEHICULO")
    private Integer idvehiculo;
    @Column(name = "IDESPA")
    private Integer idespa;
    @Column(name = "NUMESPA")
    private Integer numespa;
     @Column(name = "NUMPISO")
    private Integer numpiso;
    @Column(name = "OCUPADO")
    private Integer ocupado;
    @Column(name = "IDPISO")
    private Integer idpiso;
    @Column(name = "IDBODEGA")
    private Integer idbodega;
    @Column(name = "DIRBODEGA")
    private String dirbodega;
    @Column(name = "IDESTADO")
    private Integer idestado;
    @Column(name = "NOMMODEL")
    private String nommodel;
    @Column(name = "NOMMARCA")
    private String nommarca;

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Integer getIdespa() {
        return idespa;
    }

    public void setIdespa(Integer idespa) {
        this.idespa = idespa;
    }

    public Integer getNumespa() {
        return numespa;
    }

    public void setNumespa(Integer numespa) {
        this.numespa = numespa;
    }

    public Integer getNumpiso() {
        return numpiso;
    }

    public void setNumpiso(Integer numpiso) {
        this.numpiso = numpiso;
    }

    public Integer getOcupado() {
        return ocupado;
    }

    public void setOcupado(Integer ocupado) {
        this.ocupado = ocupado;
    }

    public Integer getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(Integer idpiso) {
        this.idpiso = idpiso;
    }

    public Integer getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Integer idbodega) {
        this.idbodega = idbodega;
    }

    public String getDirbodega() {
        return dirbodega;
    }

    public void setDirbodega(String dirbodega) {
        this.dirbodega = dirbodega;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getNommodel() {
        return nommodel;
    }

    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }

    public String getNommarca() {
        return nommarca;
    }

    public void setNommarca(String nommarca) {
        this.nommarca = nommarca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idvehiculo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EspaciosDetalle other = (EspaciosDetalle) obj;
        if (!Objects.equals(this.idvehiculo, other.idvehiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EspaciosDetalle{" + "idvehiculo=" + idvehiculo + '}';
    }
    
    
    
}
