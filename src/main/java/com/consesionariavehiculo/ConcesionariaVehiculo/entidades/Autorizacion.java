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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "AUTORIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorizacion.findAll", query = "SELECT a FROM Autorizacion a")
    , @NamedQuery(name = "Autorizacion.findByIdactualizacion", query = "SELECT a FROM Autorizacion a WHERE a.idactualizacion = :idactualizacion")
    , @NamedQuery(name = "Autorizacion.findByEstado", query = "SELECT a FROM Autorizacion a WHERE a.estado = :estado")})
public class Autorizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACTUALIZACION")
    private Integer idactualizacion;
    @Column(name = "ESTADO")
    private Boolean estado;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;

    public Autorizacion() {
    }

    public Autorizacion(Integer idactualizacion) {
        this.idactualizacion = idactualizacion;
    }

    public Integer getIdactualizacion() {
        return idactualizacion;
    }

    public void setIdactualizacion(Integer idactualizacion) {
        this.idactualizacion = idactualizacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactualizacion != null ? idactualizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorizacion)) {
            return false;
        }
        Autorizacion other = (Autorizacion) object;
        if ((this.idactualizacion == null && other.idactualizacion != null) || (this.idactualizacion != null && !this.idactualizacion.equals(other.idactualizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Autorizacion[ idactualizacion=" + idactualizacion + " ]";
    }
    
}
