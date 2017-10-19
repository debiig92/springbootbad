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
@Table(name = "TIPOVEHREM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipovehrem.findAll", query = "SELECT t FROM Tipovehrem t")
    , @NamedQuery(name = "Tipovehrem.findByIdtipovehrem", query = "SELECT t FROM Tipovehrem t WHERE t.idtipovehrem = :idtipovehrem")
    , @NamedQuery(name = "Tipovehrem.findByNomtiporem", query = "SELECT t FROM Tipovehrem t WHERE t.nomtiporem = :nomtiporem")
    , @NamedQuery(name = "Tipovehrem.findByMaxvehrem", query = "SELECT t FROM Tipovehrem t WHERE t.maxvehrem = :maxvehrem")})
public class Tipovehrem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOVEHREM")
    private Integer idtipovehrem;
    @Size(max = 50)
    @Column(name = "NOMTIPOREM")
    private String nomtiporem;
    @Column(name = "MAXVEHREM")
    private Integer maxvehrem;

    public Tipovehrem() {
    }

    public Tipovehrem(Integer idtipovehrem) {
        this.idtipovehrem = idtipovehrem;
    }

    public Integer getIdtipovehrem() {
        return idtipovehrem;
    }

    public void setIdtipovehrem(Integer idtipovehrem) {
        this.idtipovehrem = idtipovehrem;
    }

    public String getNomtiporem() {
        return nomtiporem;
    }

    public void setNomtiporem(String nomtiporem) {
        this.nomtiporem = nomtiporem;
    }

    public Integer getMaxvehrem() {
        return maxvehrem;
    }

    public void setMaxvehrem(Integer maxvehrem) {
        this.maxvehrem = maxvehrem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipovehrem != null ? idtipovehrem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipovehrem)) {
            return false;
        }
        Tipovehrem other = (Tipovehrem) object;
        if ((this.idtipovehrem == null && other.idtipovehrem != null) || (this.idtipovehrem != null && !this.idtipovehrem.equals(other.idtipovehrem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipovehrem[ idtipovehrem=" + idtipovehrem + " ]";
    }
    
}
