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
import javax.persistence.Lob;
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
@Table(name = "MULTIMEDIAVEH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multimediaveh.findAll", query = "SELECT m FROM Multimediaveh m")
    , @NamedQuery(name = "Multimediaveh.findByIdmultimediaveh", query = "SELECT m FROM Multimediaveh m WHERE m.idmultimediaveh = :idmultimediaveh")})
public class Multimediaveh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMULTIMEDIAVEH__")
    private Integer idmultimediaveh;
    @JoinColumn(name = "IDTIPOMULTIMEDIA", referencedColumnName = "IDTIPOMULTIMEDIA")
    @ManyToOne
    private Tipomultimedia idtipomultimedia;
    @Lob
    @Column(name = "MULTIMEDIA__")
    private byte[] multimedia;
    @JoinColumn(name = "IDVEHICULO", referencedColumnName = "IDVEHICULO")
    @ManyToOne
    private Vehiculo idvehiculo;
    
    public Multimediaveh() {
    }

    public Multimediaveh(Integer idmultimediaveh) {
        this.idmultimediaveh = idmultimediaveh;
    }

    public Integer getIdmultimediaveh() {
        return idmultimediaveh;
    }

    public void setIdmultimediaveh(Integer idmultimediaveh) {
        this.idmultimediaveh = idmultimediaveh;
    }

    public byte[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(byte[] multimedia) {
        this.multimedia = multimedia;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Tipomultimedia getIdtipomultimedia() {
        return idtipomultimedia;
    }

    public void setIdtipomultimedia(Tipomultimedia idtipomultimedia) {
        this.idtipomultimedia = idtipomultimedia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmultimediaveh != null ? idmultimediaveh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multimediaveh)) {
            return false;
        }
        Multimediaveh other = (Multimediaveh) object;
        if ((this.idmultimediaveh == null && other.idmultimediaveh != null) || (this.idmultimediaveh != null && !this.idmultimediaveh.equals(other.idmultimediaveh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Multimediaveh[ idmultimediaveh=" + idmultimediaveh + " ]";
    }
    
}
