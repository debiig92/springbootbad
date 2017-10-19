/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ENTSALVEH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entsalveh.findAll", query = "SELECT e FROM Entsalveh e")
    , @NamedQuery(name = "Entsalveh.findByIdentsalveh", query = "SELECT e FROM Entsalveh e WHERE e.identsalveh = :identsalveh")
    , @NamedQuery(name = "Entsalveh.findByFechaentsal", query = "SELECT e FROM Entsalveh e WHERE e.fechaentsal = :fechaentsal")
    , @NamedQuery(name = "Entsalveh.findByEntsalautorizada", query = "SELECT e FROM Entsalveh e WHERE e.entsalautorizada = :entsalautorizada")})
public class Entsalveh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTSALVEH")
    private Integer identsalveh;
    @Column(name = "FECHAENTSAL")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaentsal;
    @Column(name = "ENTSALAUTORIZADA")
    private Integer entsalautorizada;
    @OneToMany(mappedBy = "identsalveh")
    private Collection<Rentsalveh> rentsalvehCollection;
    @JoinColumn(name = "PLACAREM", referencedColumnName = "PLACAREM")
    @ManyToOne
    private Vehiculoremolque placarem;
    @JoinColumn(name = "IDBODEGUERO", referencedColumnName = "IDBODEGUERO")
    @ManyToOne
    private Bodeguero idbodeguero;
    @JoinColumn(name = "DUIMOTORISTA", referencedColumnName = "DUIMOTORISTA")
    @ManyToOne
    private Motorista duimotorista;

    public Entsalveh() {
    }

    public Entsalveh(Integer identsalveh) {
        this.identsalveh = identsalveh;
    }

    public Integer getIdentsalveh() {
        return identsalveh;
    }

    public void setIdentsalveh(Integer identsalveh) {
        this.identsalveh = identsalveh;
    }

    public Date getFechaentsal() {
        return fechaentsal;
    }

    public void setFechaentsal(Date fechaentsal) {
        this.fechaentsal = fechaentsal;
    }

    public Integer getEntsalautorizada() {
        return entsalautorizada;
    }

    public void setEntsalautorizada(Integer entsalautorizada) {
        this.entsalautorizada = entsalautorizada;
    }

    @XmlTransient
    public Collection<Rentsalveh> getRentsalvehCollection() {
        return rentsalvehCollection;
    }

    public void setRentsalvehCollection(Collection<Rentsalveh> rentsalvehCollection) {
        this.rentsalvehCollection = rentsalvehCollection;
    }

    public Vehiculoremolque getPlacarem() {
        return placarem;
    }

    public void setPlacarem(Vehiculoremolque placarem) {
        this.placarem = placarem;
    }

    public Bodeguero getIdbodeguero() {
        return idbodeguero;
    }

    public void setIdbodeguero(Bodeguero idbodeguero) {
        this.idbodeguero = idbodeguero;
    }

    public Motorista getDuimotorista() {
        return duimotorista;
    }

    public void setDuimotorista(Motorista duimotorista) {
        this.duimotorista = duimotorista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identsalveh != null ? identsalveh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entsalveh)) {
            return false;
        }
        Entsalveh other = (Entsalveh) object;
        if ((this.identsalveh == null && other.identsalveh != null) || (this.identsalveh != null && !this.identsalveh.equals(other.identsalveh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entsalveh[ identsalveh=" + identsalveh + " ]";
    }
    
}
