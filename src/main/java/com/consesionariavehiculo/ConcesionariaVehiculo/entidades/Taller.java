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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "TALLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taller.findAll", query = "SELECT t FROM Taller t")
    , @NamedQuery(name = "Taller.findByIdtaller", query = "SELECT t FROM Taller t WHERE t.idtaller = :idtaller")
    , @NamedQuery(name = "Taller.findByNomtaller", query = "SELECT t FROM Taller t WHERE t.nomtaller = :nomtaller")
    , @NamedQuery(name = "Taller.findByDirtaller", query = "SELECT t FROM Taller t WHERE t.dirtaller = :dirtaller")
    , @NamedQuery(name = "Taller.findByTallautorizado", query = "SELECT t FROM Taller t WHERE t.tallautorizado = :tallautorizado")})
public class Taller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    //
    @Column(name = "IDTALLER")
    private Integer idtaller;
    @Size(max = 50)
    @Column(name = "NOMTALLER")
    private String nomtaller;
    @Size(max = 1000)
    @Column(name = "DIRTALLER")
    private String dirtaller;
    @Column(name = "TALLAUTORIZADO")
    private Short tallautorizado;

    public Taller() {
    }

    public Taller(Integer idtaller) {
        this.idtaller = idtaller;
    }

    public Integer getIdtaller() {
        return idtaller;
    }

    public void setIdtaller(Integer idtaller) {
        this.idtaller = idtaller;
    }

    public String getNomtaller() {
        return nomtaller;
    }

    public void setNomtaller(String nomtaller) {
        this.nomtaller = nomtaller;
    }

    public String getDirtaller() {
        return dirtaller;
    }

    public void setDirtaller(String dirtaller) {
        this.dirtaller = dirtaller;
    }

    public Short getTallautorizado() {
        return tallautorizado;
    }

    public void setTallautorizado(Short tallautorizado) {
        this.tallautorizado = tallautorizado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtaller != null ? idtaller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taller)) {
            return false;
        }
        Taller other = (Taller) object;
        if ((this.idtaller == null && other.idtaller != null) || (this.idtaller != null && !this.idtaller.equals(other.idtaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Taller[ idtaller=" + idtaller + " ]";
    }
    
}
