/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "REPARACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r")
    , @NamedQuery(name = "Reparacion.findByIdreparacion", query = "SELECT r FROM Reparacion r WHERE r.idreparacion = :idreparacion")})
public class Reparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREPARACION")
    private Integer idreparacion;
    @JoinColumn(name = "IDDETVEH", referencedColumnName = "IDDETVEH")
    @ManyToOne
    private Detallevehdef iddetveh;
    @JoinColumn(name = "IDVEHTALLER", referencedColumnName = "IDVEHTALLER")
    @ManyToOne
    private Vehtaller idvehtaller;

    public Reparacion() {
    }

    public Reparacion(Integer idreparacion) {
        this.idreparacion = idreparacion;
    }

    public Integer getIdreparacion() {
        return idreparacion;
    }

    public void setIdreparacion(Integer idreparacion) {
        this.idreparacion = idreparacion;
    }

    public Detallevehdef getIddetveh() {
        return iddetveh;
    }

    public void setIddetveh(Detallevehdef iddetveh) {
        this.iddetveh = iddetveh;
    }

    public Vehtaller getIdvehtaller() {
        return idvehtaller;
    }

    public void setIdvehtaller(Vehtaller idvehtaller) {
        this.idvehtaller = idvehtaller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreparacion != null ? idreparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        if ((this.idreparacion == null && other.idreparacion != null) || (this.idreparacion != null && !this.idreparacion.equals(other.idreparacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reparacion[ idreparacion=" + idreparacion + " ]";
    }
    
}
