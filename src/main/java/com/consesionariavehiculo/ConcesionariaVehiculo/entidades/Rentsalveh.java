/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "RENTSALVEH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentsalveh.findAll", query = "SELECT r FROM Rentsalveh r")
    , @NamedQuery(name = "Rentsalveh.findByIdrentsalveh", query = "SELECT r FROM Rentsalveh r WHERE r.idrentsalveh = :idrentsalveh")
    , @NamedQuery(name = "Rentsalveh.findByMotivo", query = "SELECT r FROM Rentsalveh r WHERE r.motivo = :motivo")
    , @NamedQuery(name = "Rentsalveh.findByCostoentradabodega", query = "SELECT r FROM Rentsalveh r WHERE r.costoentradabodega = :costoentradabodega")})
public class Rentsalveh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRENTSALVEH")
    private Integer idrentsalveh;
    @Size(max = 300)
    @Column(name = "MOTIVO")
    private String motivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTOENTRADABODEGA")
    private BigDecimal costoentradabodega;
    @JoinColumn(name = "IDENTSALVEH", referencedColumnName = "IDENTSALVEH")
    @ManyToOne
    private Entsalveh identsalveh;
    @JoinColumn(name = "IDVEHICULO", referencedColumnName = "IDVEHICULO")
    @ManyToOne
    private Vehiculo idvehiculo;
    @JoinColumn(name = "NIT", referencedColumnName = "NIT")
    @ManyToOne
    private Importador nit;

    public Rentsalveh() {
    }

    public Rentsalveh(Integer idrentsalveh) {
        this.idrentsalveh = idrentsalveh;
    }

    public Integer getIdrentsalveh() {
        return idrentsalveh;
    }

    public void setIdrentsalveh(Integer idrentsalveh) {
        this.idrentsalveh = idrentsalveh;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public BigDecimal getCostoentradabodega() {
        return costoentradabodega;
    }

    public void setCostoentradabodega(BigDecimal costoentradabodega) {
        this.costoentradabodega = costoentradabodega;
    }

    public Entsalveh getIdentsalveh() {
        return identsalveh;
    }

    public void setIdentsalveh(Entsalveh identsalveh) {
        this.identsalveh = identsalveh;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
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
        hash += (idrentsalveh != null ? idrentsalveh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rentsalveh)) {
            return false;
        }
        Rentsalveh other = (Rentsalveh) object;
        if ((this.idrentsalveh == null && other.idrentsalveh != null) || (this.idrentsalveh != null && !this.idrentsalveh.equals(other.idrentsalveh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Rentsalveh[ idrentsalveh=" + idrentsalveh + " ]";
    }
    
}
