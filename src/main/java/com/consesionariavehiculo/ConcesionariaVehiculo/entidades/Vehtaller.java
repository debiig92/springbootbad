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
@Table(name = "VEHTALLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehtaller.findAll", query = "SELECT v FROM Vehtaller v")
    , @NamedQuery(name = "Vehtaller.findByIdvehtaller", query = "SELECT v FROM Vehtaller v WHERE v.idvehtaller = :idvehtaller")
    , @NamedQuery(name = "Vehtaller.findByIdvehiculo", query = "SELECT v FROM Vehtaller v WHERE v.idvehiculo = :idvehiculo")
    , @NamedQuery(name = "Vehtaller.findByNit", query = "SELECT v FROM Vehtaller v WHERE v.nit = :nit")
    , @NamedQuery(name = "Vehtaller.findByIdsaltaller", query = "SELECT v FROM Vehtaller v WHERE v.idsaltaller = :idsaltaller")})
public class Vehtaller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVEHTALLER")
    private Integer idvehtaller;
    @Column(name = "IDVEHICULO")
    private Integer idvehiculo;
    @Size(max = 14)
    @Column(name = "NIT")
    private String nit;
    @Column(name = "IDSALTALLER")
    private Integer idsaltaller;
    @OneToMany(mappedBy = "idvehtaller")
    private Collection<Reparacion> reparacionCollection;
    @Column(name = "COSTOTALL")
    private Integer costotall;
    public Vehtaller() {
    }

    public Vehtaller(Integer idvehtaller) {
        this.idvehtaller = idvehtaller;
    }

    public Integer getIdvehtaller() {
        return idvehtaller;
    }

    public void setIdvehtaller(Integer idvehtaller) {
        this.idvehtaller = idvehtaller;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getIdsaltaller() {
        return idsaltaller;
    }

    public void setIdsaltaller(Integer idsaltaller) {
        this.idsaltaller = idsaltaller;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    public Integer getCostotall() {
        return costotall;
    }

    public void setCostotall(Integer costotall) {
        this.costotall = costotall;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehtaller != null ? idvehtaller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehtaller)) {
            return false;
        }
        Vehtaller other = (Vehtaller) object;
        if ((this.idvehtaller == null && other.idvehtaller != null) || (this.idvehtaller != null && !this.idvehtaller.equals(other.idvehtaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vehtaller[ idvehtaller=" + idvehtaller + " ]";
    }
    
}
