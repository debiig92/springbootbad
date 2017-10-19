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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DETALLEVEHDEF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallevehdef.findAll", query = "SELECT d FROM Detallevehdef d")
    , @NamedQuery(name = "Detallevehdef.findByIddetveh", query = "SELECT d FROM Detallevehdef d WHERE d.iddetveh = :iddetveh")
    , @NamedQuery(name = "Detallevehdef.findByDetalledef", query = "SELECT d FROM Detallevehdef d WHERE d.detalledef = :detalledef")})
public class Detallevehdef implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDETVEH")
    private Integer iddetveh;
    @NotNull
    @Column(name = "reparado")
    private Integer reparado;
    @Size(max = 1000)
    @Column(name = "DETALLEDEF")
    private String detalledef;
    @JoinColumn(name = "IDVEHICULO", referencedColumnName = "IDVEHICULO")
    @ManyToOne
    private Vehiculo idvehiculo;
    @OneToMany(mappedBy = "iddetveh")
    private Collection<Reparacion> reparacionCollection;

    public Detallevehdef() {
    }

    public Detallevehdef(Integer iddetveh) {
        this.iddetveh = iddetveh;
    }

    public Integer getIddetveh() {
        return iddetveh;
    }

    public void setIddetveh(Integer iddetveh) {
        this.iddetveh = iddetveh;
    }

    public String getDetalledef() {
        return detalledef;
    }

    public void setDetalledef(String detalledef) {
        this.detalledef = detalledef;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Integer getReparado() {
        return reparado;
    }

    public void setReparado(Integer reparado) {
        this.reparado = reparado;
    }
  

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetveh != null ? iddetveh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallevehdef)) {
            return false;
        }
        Detallevehdef other = (Detallevehdef) object;
        if ((this.iddetveh == null && other.iddetveh != null) || (this.iddetveh != null && !this.iddetveh.equals(other.iddetveh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detallevehdef[ iddetveh=" + iddetveh + " ]";
    }
    
}
