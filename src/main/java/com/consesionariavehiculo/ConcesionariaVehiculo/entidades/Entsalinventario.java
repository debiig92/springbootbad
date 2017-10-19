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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ENTSALINVENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entsalinventario.findAll", query = "SELECT e FROM Entsalinventario e")
    , @NamedQuery(name = "Entsalinventario.findByIdentsalinve", query = "SELECT e FROM Entsalinventario e WHERE e.identsalinve = :identsalinve")
    , @NamedQuery(name = "Entsalinventario.findByFechaingreso", query = "SELECT e FROM Entsalinventario e WHERE e.fechaingreso = :fechaingreso")
    , @NamedQuery(name = "Entsalinventario.findByFechasalida", query = "SELECT e FROM Entsalinventario e WHERE e.fechasalida = :fechasalida")
    , @NamedQuery(name = "Entsalinventario.findByIdusuariosol", query = "SELECT e FROM Entsalinventario e WHERE e.idusuariosol = :idusuariosol")
    , @NamedQuery(name = "Entsalinventario.findByIdusuarioacep", query = "SELECT e FROM Entsalinventario e WHERE e.idusuarioacep = :idusuarioacep")})
public class Entsalinventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTSALINVE")
    private Integer identsalinve;
    @Column(name = "FECHAINGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Column(name = "FECHASALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @Column(name = "IDUSUARIOSOL")
    private Integer idusuariosol;
    @Column(name = "IDUSUARIOACEP")
    private Integer idusuarioacep;
    @OneToMany(mappedBy = "identsalinve")
    private Collection<Catalogovehiculo> catalogovehiculoCollection;

    public Entsalinventario() {
    }

    public Entsalinventario(Integer identsalinve) {
        this.identsalinve = identsalinve;
    }

    public Integer getIdentsalinve() {
        return identsalinve;
    }

    public void setIdentsalinve(Integer identsalinve) {
        this.identsalinve = identsalinve;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Integer getIdusuariosol() {
        return idusuariosol;
    }

    public void setIdusuariosol(Integer idusuariosol) {
        this.idusuariosol = idusuariosol;
    }

    public Integer getIdusuarioacep() {
        return idusuarioacep;
    }

    public void setIdusuarioacep(Integer idusuarioacep) {
        this.idusuarioacep = idusuarioacep;
    }

    @XmlTransient
    public Collection<Catalogovehiculo> getCatalogovehiculoCollection() {
        return catalogovehiculoCollection;
    }

    public void setCatalogovehiculoCollection(Collection<Catalogovehiculo> catalogovehiculoCollection) {
        this.catalogovehiculoCollection = catalogovehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identsalinve != null ? identsalinve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entsalinventario)) {
            return false;
        }
        Entsalinventario other = (Entsalinventario) object;
        if ((this.identsalinve == null && other.identsalinve != null) || (this.identsalinve != null && !this.identsalinve.equals(other.identsalinve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entsalinventario[ identsalinve=" + identsalinve + " ]";
    }
    
}
