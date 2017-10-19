/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "VEHICULOREMOLQUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculoremolque.findAll", query = "SELECT v FROM Vehiculoremolque v")
    , @NamedQuery(name = "Vehiculoremolque.findByPlacarem", query = "SELECT v FROM Vehiculoremolque v WHERE v.placarem = :placarem")
    , @NamedQuery(name = "Vehiculoremolque.findByIdtipovehrem", query = "SELECT v FROM Vehiculoremolque v WHERE v.idtipovehrem = :idtipovehrem")})
public class Vehiculoremolque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "PLACAREM")
    private String placarem;
    @Column(name = "IDTIPOVEHREM")
    private Integer idtipovehrem;
    @OneToMany(mappedBy = "placarem")
    private Collection<Entsalveh> entsalvehCollection;

    public Vehiculoremolque() {
    }

    public Vehiculoremolque(String placarem) {
        this.placarem = placarem;
    }

    public String getPlacarem() {
        return placarem;
    }

    public void setPlacarem(String placarem) {
        this.placarem = placarem;
    }

    public Integer getIdtipovehrem() {
        return idtipovehrem;
    }

    public void setIdtipovehrem(Integer idtipovehrem) {
        this.idtipovehrem = idtipovehrem;
    }

    @XmlTransient
    public Collection<Entsalveh> getEntsalvehCollection() {
        return entsalvehCollection;
    }

    public void setEntsalvehCollection(Collection<Entsalveh> entsalvehCollection) {
        this.entsalvehCollection = entsalvehCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placarem != null ? placarem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculoremolque)) {
            return false;
        }
        Vehiculoremolque other = (Vehiculoremolque) object;
        if ((this.placarem == null && other.placarem != null) || (this.placarem != null && !this.placarem.equals(other.placarem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vehiculoremolque[ placarem=" + placarem + " ]";
    }
    
}
