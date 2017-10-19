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
@Table(name = "RESPAVEH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respaveh.findAll", query = "SELECT r FROM Respaveh r")
    , @NamedQuery(name = "Respaveh.findByIdrespaveh", query = "SELECT r FROM Respaveh r WHERE r.idrespaveh = :idrespaveh")})
public class Respaveh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESPAVEH")
    private Integer idrespaveh;
    @JoinColumn(name = "IDVEHICULO", referencedColumnName = "IDVEHICULO")
    @ManyToOne
    private Vehiculo idvehiculo;
    @JoinColumn(name = "IDESPA", referencedColumnName = "IDESPA")
    @ManyToOne
    private Espavehiculo idespa;

    public Respaveh() {
    }

    public Respaveh(Integer idrespaveh) {
        this.idrespaveh = idrespaveh;
    }

    public Integer getIdrespaveh() {
        return idrespaveh;
    }

    public void setIdrespaveh(Integer idrespaveh) {
        this.idrespaveh = idrespaveh;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Espavehiculo getIdespa() {
        return idespa;
    }

    public void setIdespa(Espavehiculo idespa) {
        this.idespa = idespa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrespaveh != null ? idrespaveh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respaveh)) {
            return false;
        }
        Respaveh other = (Respaveh) object;
        if ((this.idrespaveh == null && other.idrespaveh != null) || (this.idrespaveh != null && !this.idrespaveh.equals(other.idrespaveh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Respaveh[ idrespaveh=" + idrespaveh + " ]";
    }
    
}
