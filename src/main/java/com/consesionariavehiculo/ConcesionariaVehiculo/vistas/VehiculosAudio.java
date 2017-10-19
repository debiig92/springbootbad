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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Humberto
 */
@Entity
@Table(name = "vehiculosaudio")
public class VehiculosAudio implements Serializable{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDIMAGENVEH")
    private Integer idimagenveh;
    @Basic(optional = false)
    @Column(name = "IDVEHICULO")
    private Integer idvehiculo;
    @Column(name = "NOMMARCA")
    private String nommarca;
    @Column(name = "IDESTADO")
    private Integer idestado;
    @Column(name = "NOMMODEL")
    private String nommodel;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "PRECIOSALIDA")
    private BigDecimal preciosalida;
     @Column(name = "IDMODELO")
    private Integer idmodelo;
    @Column(name = "IDMARCA")
    private Integer idmarca;
    @Lob
    @Column(name = "IMAGEN")
    private byte[] imagen;

    public Integer getIdimagenveh() {
        return idimagenveh;
    }

    public void setIdimagenveh(Integer idimagenveh) {
        this.idimagenveh = idimagenveh;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getNommarca() {
        return nommarca;
    }

    public void setNommarca(String nommarca) {
        this.nommarca = nommarca;
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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public BigDecimal getPreciosalida() {
        return preciosalida;
    }

    public void setPreciosalida(BigDecimal preciosalida) {
        this.preciosalida = preciosalida;
    }

    public Integer getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Integer idmodelo) {
        this.idmodelo = idmodelo;
    }

    public Integer getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.idimagenveh);
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
        final VehiculosAudio other = (VehiculosAudio) obj;
        if (!Objects.equals(this.idimagenveh, other.idimagenveh)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VehiculosAudio{" + "idimagenveh=" + idimagenveh + '}';
    }
    
    
}
