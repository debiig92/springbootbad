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
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona")
    , @NamedQuery(name = "Persona.findByNomper", query = "SELECT p FROM Persona p WHERE p.nomper = :nomper")
    , @NamedQuery(name = "Persona.findByApeper", query = "SELECT p FROM Persona p WHERE p.apeper = :apeper")
    , @NamedQuery(name = "Persona.findByDirper", query = "SELECT p FROM Persona p WHERE p.dirper = :dirper")
    , @NamedQuery(name = "Persona.findByTelper", query = "SELECT p FROM Persona p WHERE p.telper = :telper")
    , @NamedQuery(name = "Persona.findByCorreoper", query = "SELECT p FROM Persona p WHERE p.correoper = :correoper")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPERSONA")
    private Integer idpersona;
    @Size(max = 50)
    @Column(name = "NOMPER")
    private String nomper;
    @Size(max = 50)
    @Column(name = "APEPER")
    private String apeper;
    @Size(max = 50)
    @Column(name = "DIRPER")
    private String dirper;
    @Column(name = "TELPER")
    private Integer telper;
    @Size(max = 100)
    @Column(name = "CORREOPER")
    private String correoper;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;

    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getApeper() {
        return apeper;
    }

    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    public String getDirper() {
        return dirper;
    }

    public void setDirper(String dirper) {
        this.dirper = dirper;
    }

    public Integer getTelper() {
        return telper;
    }

    public void setTelper(Integer telper) {
        this.telper = telper;
    }

    public String getCorreoper() {
        return correoper;
    }

    public void setCorreoper(String correoper) {
        this.correoper = correoper;
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
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ idpersona=" + idpersona + " ]";
    }
    
}
