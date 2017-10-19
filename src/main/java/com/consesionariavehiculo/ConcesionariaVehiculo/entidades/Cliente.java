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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByDuicliente", query = "SELECT c FROM Cliente c WHERE c.duicliente = :duicliente")
    , @NamedQuery(name = "Cliente.findByNomcliente", query = "SELECT c FROM Cliente c WHERE c.nomcliente = :nomcliente")
    , @NamedQuery(name = "Cliente.findByApecliente", query = "SELECT c FROM Cliente c WHERE c.apecliente = :apecliente")
    , @NamedQuery(name = "Cliente.findByDircliente", query = "SELECT c FROM Cliente c WHERE c.dircliente = :dircliente")
    , @NamedQuery(name = "Cliente.findByTelcliente", query = "SELECT c FROM Cliente c WHERE c.telcliente = :telcliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DUICLIENTE")
    private String duicliente;
    @Size(max = 50)
    @Column(name = "NOMCLIENTE")
    private String nomcliente;
    @Size(max = 50)
    @Column(name = "APECLIENTE")
    private String apecliente;
    @Size(max = 1000)
    @Column(name = "DIRCLIENTE")
    private String dircliente;
    @Size(max = 8)
    @Column(name = "TELCLIENTE")
    private String telcliente;
    @OneToMany(mappedBy = "duicliente")
    private Collection<Clienteveh> clientevehCollection;

    public Cliente() {
    }

    public Cliente(String duicliente) {
        this.duicliente = duicliente;
    }

    public String getDuicliente() {
        return duicliente;
    }

    public void setDuicliente(String duicliente) {
        this.duicliente = duicliente;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }

    public String getApecliente() {
        return apecliente;
    }

    public void setApecliente(String apecliente) {
        this.apecliente = apecliente;
    }

    public String getDircliente() {
        return dircliente;
    }

    public void setDircliente(String dircliente) {
        this.dircliente = dircliente;
    }

    public String getTelcliente() {
        return telcliente;
    }

    public void setTelcliente(String telcliente) {
        this.telcliente = telcliente;
    }

    @XmlTransient
    public Collection<Clienteveh> getClientevehCollection() {
        return clientevehCollection;
    }

    public void setClientevehCollection(Collection<Clienteveh> clientevehCollection) {
        this.clientevehCollection = clientevehCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (duicliente != null ? duicliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.duicliente == null && other.duicliente != null) || (this.duicliente != null && !this.duicliente.equals(other.duicliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ duicliente=" + duicliente + " ]";
    }
    
}
