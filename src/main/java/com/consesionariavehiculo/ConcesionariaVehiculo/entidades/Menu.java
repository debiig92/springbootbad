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
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByIdelemento", query = "SELECT m FROM Menu m WHERE m.idelemento = :idelemento")
    , @NamedQuery(name = "Menu.findByNomelemento", query = "SELECT m FROM Menu m WHERE m.nomelemento = :nomelemento")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDELEMENTO")
    private Integer idelemento;
    @Size(max = 100)
    @Column(name = "NOMELEMENTO")
    private String nomelemento;
    @OneToMany(mappedBy = "idelemento")
    private Collection<Privilegio> privilegioCollection;

    public Menu() {
    }

    public Menu(Integer idelemento) {
        this.idelemento = idelemento;
    }

    public Integer getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(Integer idelemento) {
        this.idelemento = idelemento;
    }

    public String getNomelemento() {
        return nomelemento;
    }

    public void setNomelemento(String nomelemento) {
        this.nomelemento = nomelemento;
    }

    @XmlTransient
    public Collection<Privilegio> getPrivilegioCollection() {
        return privilegioCollection;
    }

    public void setPrivilegioCollection(Collection<Privilegio> privilegioCollection) {
        this.privilegioCollection = privilegioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelemento != null ? idelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idelemento == null && other.idelemento != null) || (this.idelemento != null && !this.idelemento.equals(other.idelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Menu[ idelemento=" + idelemento + " ]";
    }
    
}
