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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "SALTALLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saltaller.findAll", query = "SELECT s FROM Saltaller s")
    , @NamedQuery(name = "Saltaller.findByIdsaltaller", query = "SELECT s FROM Saltaller s WHERE s.idsaltaller = :idsaltaller")
    , @NamedQuery(name = "Saltaller.findByIdtaller", query = "SELECT s FROM Saltaller s WHERE s.idtaller = :idtaller")
    , @NamedQuery(name = "Saltaller.findByDuimotorista", query = "SELECT s FROM Saltaller s WHERE s.duimotorista = :duimotorista")
    , @NamedQuery(name = "Saltaller.findByPlacarem", query = "SELECT s FROM Saltaller s WHERE s.placarem = :placarem")
    , @NamedQuery(name = "Saltaller.findByFechaingtaller", query = "SELECT s FROM Saltaller s WHERE s.fechaingtaller = :fechaingtaller")})
public class Saltaller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSALTALLER")
    private Integer idsaltaller;
    @Size(max = 10)
    @Column(name = "IDTALLER")
    private String idtaller;
    @Size(max = 9)
    @Column(name = "DUIMOTORISTA")
    private String duimotorista;
    @Size(max = 9)
    @Column(name = "PLACAREM")
    private String placarem;
    @Column(name = "FECHAINGTALLER")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaingtaller;

    public Saltaller() {
    }

    public Saltaller(Integer idsaltaller) {
        this.idsaltaller = idsaltaller;
    }

    public Integer getIdsaltaller() {
        return idsaltaller;
    }

    public void setIdsaltaller(Integer idsaltaller) {
        this.idsaltaller = idsaltaller;
    }

    public String getIdtaller() {
        return idtaller;
    }

    public void setIdtaller(String idtaller) {
        this.idtaller = idtaller;
    }

    public String getDuimotorista() {
        return duimotorista;
    }

    public void setDuimotorista(String duimotorista) {
        this.duimotorista = duimotorista;
    }

    public String getPlacarem() {
        return placarem;
    }

    public void setPlacarem(String placarem) {
        this.placarem = placarem;
    }

    public Date getFechaingtaller() {
        return fechaingtaller;
    }

    public void setFechaingtaller(Date fechaingtaller) {
        this.fechaingtaller = fechaingtaller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsaltaller != null ? idsaltaller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saltaller)) {
            return false;
        }
        Saltaller other = (Saltaller) object;
        if ((this.idsaltaller == null && other.idsaltaller != null) || (this.idsaltaller != null && !this.idsaltaller.equals(other.idsaltaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Saltaller[ idsaltaller=" + idsaltaller + " ]";
    }
    
}
