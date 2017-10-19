/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.vistas;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author user
 */
@Entity
@Table(name = "relacionentsal")
public class Relacionentsal {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVEHICULO")
    private Integer idvehiculo;
    @Column(name = "IDRENTSALVEH")
    private Integer idrentsalveh;
    @Column(name = "MOTIVO")
    private String motivo;
    @Column(name = "IDENTSALVEH")
    private Integer identsalveh;
    @Column(name = "NIT")
    private String nit;
    @Column(name = "NOMMARCA")
    private String nommarca;
    @Column(name = "NOMMODEL")
    private String nommodel;
    @Column(name = "ENTSALAUTORIZADA")
    private Integer entsalautorizada;
    @Column(name = "FECHAENTSAL")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaentsal;

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
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

    public Integer getIdentsalveh() {
        return identsalveh;
    }

    public void setIdentsalveh(Integer identsalveh) {
        this.identsalveh = identsalveh;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNommarca() {
        return nommarca;
    }

    public void setNommarca(String nommarca) {
        this.nommarca = nommarca;
    }

    public String getNommodel() {
        return nommodel;
    }

    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }

    public Integer getEntsalautorizada() {
        return entsalautorizada;
    }

    public void setEntsalautorizada(Integer entsalautorizada) {
        this.entsalautorizada = entsalautorizada;
    }

    public Date getFechaentsal() {
        return fechaentsal;
    }

    public void setFechaentsal(Date fechaentsal) {
        this.fechaentsal = fechaentsal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idvehiculo);
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
        final Relacionentsal other = (Relacionentsal) obj;
        if (!Objects.equals(this.idvehiculo, other.idvehiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Relacionentsal{" + "idvehiculo=" + idvehiculo + '}';
    }
    
    

}
