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
@Table(name = "ESPAVEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espavehiculo.findAll", query = "SELECT e FROM Espavehiculo e")
    , @NamedQuery(name = "Espavehiculo.findByIdespa", query = "SELECT e FROM Espavehiculo e WHERE e.idespa = :idespa")
    , @NamedQuery(name = "Espavehiculo.findByNumespa", query = "SELECT e FROM Espavehiculo e WHERE e.numespa = :numespa")
    , @NamedQuery(name = "Espavehiculo.findByOcupado", query = "SELECT e FROM Espavehiculo e WHERE e.ocupado = :ocupado")})
public class Espavehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDESPA")
    private Integer idespa;
    @Column(name = "NUMESPA")
    private Integer numespa;
    @Column(name = "OCUPADO")
    private Short ocupado;
    @JoinColumn(name = "IDPISO", referencedColumnName = "IDPISO")
    @ManyToOne
    private Piso idpiso;
    @OneToMany(mappedBy = "idespa")
    private Collection<Respaveh> respavehCollection;

    public Espavehiculo() {
    }

    public Espavehiculo(Integer idespa) {
        this.idespa = idespa;
    }

    public Integer getIdespa() {
        return idespa;
    }

    public void setIdespa(Integer idespa) {
        this.idespa = idespa;
    }

    public Integer getNumespa() {
        return numespa;
    }

    public void setNumespa(Integer numespa) {
        this.numespa = numespa;
    }

    public Short getOcupado() {
        return ocupado;
    }

    public void setOcupado(Short ocupado) {
        this.ocupado = ocupado;
    }

    public Piso getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(Piso idpiso) {
        this.idpiso = idpiso;
    }

    @XmlTransient
    public Collection<Respaveh> getRespavehCollection() {
        return respavehCollection;
    }

    public void setRespavehCollection(Collection<Respaveh> respavehCollection) {
        this.respavehCollection = respavehCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespa != null ? idespa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espavehiculo)) {
            return false;
        }
        Espavehiculo other = (Espavehiculo) object;
        if ((this.idespa == null && other.idespa != null) || (this.idespa != null && !this.idespa.equals(other.idespa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Espavehiculo[ idespa=" + idespa + " ]";
    }
    
}
