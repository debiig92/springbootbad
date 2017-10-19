/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "IMPORTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importacion.findAll", query = "SELECT i FROM Importacion i")
    , @NamedQuery(name = "Importacion.findByIdimport", query = "SELECT i FROM Importacion i WHERE i.idimport = :idimport")
    , @NamedQuery(name = "Importacion.findByFecimport", query = "SELECT i FROM Importacion i WHERE i.fecimport = :fecimport")})
public class Importacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDIMPORT")
    private Integer idimport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECIMPORT")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecimport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTVEH")
    private Integer cantveh;
    @JoinColumn(name = "NIT", referencedColumnName = "NIT")
    @ManyToOne
    private Importador nit;

    public Importacion() {
    }

    public Importacion(Integer idimport) {
        this.idimport = idimport;
    }

    public Importacion(Integer idimport, Date fecimport) {
        this.idimport = idimport;
        this.fecimport = fecimport;
    }

    public Integer getIdimport() {
        return idimport;
    }

    public void setIdimport(Integer idimport) {
        this.idimport = idimport;
    }

    public Date getFecimport() {
        return fecimport;
    }

    public void setFecimport(Date fecimport) {
        this.fecimport = fecimport;
    }

    public Integer getCantveh() {
        return cantveh;
    }

    public void setCantveh(Integer cantveh) {
        this.cantveh = cantveh;
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
        hash += (idimport != null ? idimport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Importacion)) {
            return false;
        }
        Importacion other = (Importacion) object;
        if ((this.idimport == null && other.idimport != null) || (this.idimport != null && !this.idimport.equals(other.idimport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Importacion[ idimport=" + idimport + " ]";
    }
    
}
