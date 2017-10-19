/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.vistas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Entity
@Table(name = "vehiculosventa")
public class Vehiculosventa implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVEHICULO")
    private Integer idvehiculo;
    @Column(name = "NOMESTADO")
    private String nomestado;
    @Column(name = "NOMMARCA")
    private String nommarca;
    @Column(name = "IDESTADO")
    private Integer idestado;
    @Column(name = "NOMMODEL")
    private String nommodel;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "IDIMPORT")
    private Integer idimport;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIOSALIDA")
    private BigDecimal preciosalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTOINICIAL")
    private BigDecimal costoinicial;

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getNomestado() {
        return nomestado;
    }

    public void setNomestado(String nomestado) {
        this.nomestado = nomestado;
    }

    public String getNommarca() {
        return nommarca;
    }

    public void setNommarca(String nommarca) {
        this.nommarca = nommarca;
    }

    public String getNommodel() {
        return nommodel;
    }

    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getIdimport() {
        return idimport;
    }

    public void setIdimport(Integer idimport) {
        this.idimport = idimport;
    }

    public BigDecimal getPreciosalida() {
        return preciosalida;
    }

    public void setPreciosalida(BigDecimal preciosalida) {
        this.preciosalida = preciosalida;
    }

    public BigDecimal getCostoinicial() {
        return costoinicial;
    }

    public void setCostoinicial(BigDecimal costoinicial) {
        this.costoinicial = costoinicial;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idvehiculo);
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
        final Vehiculosventa other = (Vehiculosventa) obj;
        if (!Objects.equals(this.idvehiculo, other.idvehiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "idvehiculo=" + idvehiculo + '}';
    }
    
    
}
