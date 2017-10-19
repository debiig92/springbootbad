/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.vistas;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Humberto
 */
@Entity
@Table(name = "importaciones")
public class Importaciones implements Serializable{
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "NIT")
    private String nit;

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idimport);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Importaciones other = (Importaciones) obj;
        if (!Objects.equals(this.idimport, other.idimport)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Importaciones{" + "idimport=" + idimport + '}';
    }
    
    
}
