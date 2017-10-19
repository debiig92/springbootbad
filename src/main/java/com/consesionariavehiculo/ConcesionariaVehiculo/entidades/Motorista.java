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
@Table(name = "MOTORISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motorista.findAll", query = "SELECT m FROM Motorista m")
    , @NamedQuery(name = "Motorista.findByDuimotorista", query = "SELECT m FROM Motorista m WHERE m.duimotorista = :duimotorista")
    , @NamedQuery(name = "Motorista.findByNommotorista", query = "SELECT m FROM Motorista m WHERE m.nommotorista = :nommotorista")
    , @NamedQuery(name = "Motorista.findByApemotorista", query = "SELECT m FROM Motorista m WHERE m.apemotorista = :apemotorista")
    , @NamedQuery(name = "Motorista.findByDirmotorista", query = "SELECT m FROM Motorista m WHERE m.dirmotorista = :dirmotorista")
    , @NamedQuery(name = "Motorista.findByTelmotorista", query = "SELECT m FROM Motorista m WHERE m.telmotorista = :telmotorista")
    , @NamedQuery(name = "Motorista.findByCormotorista", query = "SELECT m FROM Motorista m WHERE m.cormotorista = :cormotorista")})
public class Motorista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DUIMOTORISTA")
    private String duimotorista;
    @Size(max = 50)
    @Column(name = "NOMMOTORISTA")
    private String nommotorista;
    @Size(max = 50)
    @Column(name = "APEMOTORISTA")
    private String apemotorista;
    @Size(max = 1000)
    @Column(name = "DIRMOTORISTA")
    private String dirmotorista;
    @Size(max = 8)
    @Column(name = "TELMOTORISTA")
    private String telmotorista;
    @Size(max = 100)
    @Column(name = "CORMOTORISTA")
    private String cormotorista;
    @OneToMany(mappedBy = "duimotorista")
    private Collection<Entsalveh> entsalvehCollection;

    public Motorista() {
    }

    public Motorista(String duimotorista) {
        this.duimotorista = duimotorista;
    }

    public String getDuimotorista() {
        return duimotorista;
    }

    public void setDuimotorista(String duimotorista) {
        this.duimotorista = duimotorista;
    }

    public String getNommotorista() {
        return nommotorista;
    }

    public void setNommotorista(String nommotorista) {
        this.nommotorista = nommotorista;
    }

    public String getApemotorista() {
        return apemotorista;
    }

    public void setApemotorista(String apemotorista) {
        this.apemotorista = apemotorista;
    }

    public String getDirmotorista() {
        return dirmotorista;
    }

    public void setDirmotorista(String dirmotorista) {
        this.dirmotorista = dirmotorista;
    }

    public String getTelmotorista() {
        return telmotorista;
    }

    public void setTelmotorista(String telmotorista) {
        this.telmotorista = telmotorista;
    }

    public String getCormotorista() {
        return cormotorista;
    }

    public void setCormotorista(String cormotorista) {
        this.cormotorista = cormotorista;
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
        hash += (duimotorista != null ? duimotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        if ((this.duimotorista == null && other.duimotorista != null) || (this.duimotorista != null && !this.duimotorista.equals(other.duimotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Motorista[ duimotorista=" + duimotorista + " ]";
    }
    
}
