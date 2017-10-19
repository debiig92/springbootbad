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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "CONTACTOIMPORTADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactoimportador.findAll", query = "SELECT c FROM Contactoimportador c")
    , @NamedQuery(name = "Contactoimportador.findByIdcontacto", query = "SELECT c FROM Contactoimportador c WHERE c.idcontacto = :idcontacto")
    , @NamedQuery(name = "Contactoimportador.findByNumtel", query = "SELECT c FROM Contactoimportador c WHERE c.numtel = :numtel")})
public class Contactoimportador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONTACTO")
    private Integer idcontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "NUMTEL")
    private String numtel;
    @JoinColumn(name = "NIT", referencedColumnName = "NIT")
    @ManyToOne
    private Importador nit;

    public Contactoimportador() {
    }

    public Contactoimportador(Integer idcontacto) {
        this.idcontacto = idcontacto;
    }

    public Contactoimportador(Integer idcontacto, String numtel) {
        this.idcontacto = idcontacto;
        this.numtel = numtel;
    }

    public Integer getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(Integer idcontacto) {
        this.idcontacto = idcontacto;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public Importador getNit() {
        return nit;
    }

    public void setNit(Importador nit) {
        this.nit = nit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontacto != null ? idcontacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactoimportador)) {
            return false;
        }
        Contactoimportador other = (Contactoimportador) object;
        if ((this.idcontacto == null && other.idcontacto != null) || (this.idcontacto != null && !this.idcontacto.equals(other.idcontacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Contactoimportador[ idcontacto=" + idcontacto + " ]";
    }
    
}
