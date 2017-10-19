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
@Table(name = "BODEGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b")
    , @NamedQuery(name = "Bodega.findByIdbodega", query = "SELECT b FROM Bodega b WHERE b.idbodega = :idbodega")
    , @NamedQuery(name = "Bodega.findByDirbodega", query = "SELECT b FROM Bodega b WHERE b.dirbodega = :dirbodega")
    , @NamedQuery(name = "Bodega.findByMaxpisos", query = "SELECT b FROM Bodega b WHERE b.maxpisos = :maxpisos")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBODEGA")
    private Integer idbodega;
    @Size(max = 1000)
    @Column(name = "DIRBODEGA")
    private String dirbodega;
    @Column(name = "MAXPISOS")
    private Integer maxpisos;
    @OneToMany(mappedBy = "idbodega")
    private Collection<Bodeguero> bodegueroCollection;
    @OneToMany(mappedBy = "idbodega")
    private Collection<Piso> pisoCollection;
    @Column(name = "CANTPISOS")
    private Integer cantpisos;
    public Bodega() {
    }

    public Bodega(Integer idbodega) {
        this.idbodega = idbodega;
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

    public Integer getMaxpisos() {
        return maxpisos;
    }

    public void setMaxpisos(Integer maxpisos) {
        this.maxpisos = maxpisos;
    }

    public Integer getCantpisos() {
        return cantpisos;
    }

    public void setCantpisos(Integer cantpisos) {
        this.cantpisos = cantpisos;
    }

    
    
    @XmlTransient
    public Collection<Bodeguero> getBodegueroCollection() {
        return bodegueroCollection;
    }

    public void setBodegueroCollection(Collection<Bodeguero> bodegueroCollection) {
        this.bodegueroCollection = bodegueroCollection;
    }

    @XmlTransient
    public Collection<Piso> getPisoCollection() {
        return pisoCollection;
    }

    public void setPisoCollection(Collection<Piso> pisoCollection) {
        this.pisoCollection = pisoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbodega != null ? idbodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idbodega == null && other.idbodega != null) || (this.idbodega != null && !this.idbodega.equals(other.idbodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bodega[ idbodega=" + idbodega + " ]";
    }
    
}
