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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "PISO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piso.findAll", query = "SELECT p FROM Piso p")
    , @NamedQuery(name = "Piso.findByIdpiso", query = "SELECT p FROM Piso p WHERE p.idpiso = :idpiso")
    , @NamedQuery(name = "Piso.findByMaxespa", query = "SELECT p FROM Piso p WHERE p.maxespa = :maxespa")
    , @NamedQuery(name = "Piso.findByNumpiso", query = "SELECT p FROM Piso p WHERE p.numpiso = :numpiso")})
public class Piso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPISO")
    private Integer idpiso;
    @Column(name = "MAXESPA")
    private Integer maxespa;
    @Column(name = "NUMPISO")
    private Integer numpiso;
     @Column(name = "CANTESPA")
    private Integer cantespa;
    @OneToMany(mappedBy = "idpiso")
    private Collection<Espavehiculo> espavehiculoCollection;
    @JoinColumn(name = "IDBODEGA", referencedColumnName = "IDBODEGA")
    @ManyToOne
    private Bodega idbodega;

    public Piso() {
    }

    public Piso(Integer idpiso) {
        this.idpiso = idpiso;
    }

    public Integer getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(Integer idpiso) {
        this.idpiso = idpiso;
    }

    public Integer getMaxespa() {
        return maxespa;
    }

    public void setMaxespa(Integer maxespa) {
        this.maxespa = maxespa;
    }

    public Integer getNumpiso() {
        return numpiso;
    }

    public void setNumpiso(Integer numpiso) {
        this.numpiso = numpiso;
    }

    @XmlTransient
    public Collection<Espavehiculo> getEspavehiculoCollection() {
        return espavehiculoCollection;
    }

    public void setEspavehiculoCollection(Collection<Espavehiculo> espavehiculoCollection) {
        this.espavehiculoCollection = espavehiculoCollection;
    }

    public Bodega getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Bodega idbodega) {
        this.idbodega = idbodega;
    }

    public Integer getCantespa() {
        return cantespa;
    }

    public void setCantespa(Integer cantespa) {
        this.cantespa = cantespa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpiso != null ? idpiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piso)) {
            return false;
        }
        Piso other = (Piso) object;
        if ((this.idpiso == null && other.idpiso != null) || (this.idpiso != null && !this.idpiso.equals(other.idpiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Piso[ idpiso=" + idpiso + " ]";
    }
    
}
