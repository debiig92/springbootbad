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
@Table(name = "PRIVILEGIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegio.findAll", query = "SELECT p FROM Privilegio p")
    , @NamedQuery(name = "Privilegio.findByIdprivilegio", query = "SELECT p FROM Privilegio p WHERE p.idprivilegio = :idprivilegio")
    , @NamedQuery(name = "Privilegio.findByActivo", query = "SELECT p FROM Privilegio p WHERE p.activo = :activo")})
public class Privilegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRIVILEGIO")
    private Integer idprivilegio;
    @Column(name = "ACTIVO")
    private Short activo;
    @JoinColumn(name = "IDROL", referencedColumnName = "IDROL")
    @ManyToOne
    private Rol idrol;
    @JoinColumn(name = "IDELEMENTO", referencedColumnName = "IDELEMENTO")
    @ManyToOne
    private Menu idelemento;

    public Privilegio() {
    }

    public Privilegio(Integer idprivilegio) {
        this.idprivilegio = idprivilegio;
    }

    public Integer getIdprivilegio() {
        return idprivilegio;
    }

    public void setIdprivilegio(Integer idprivilegio) {
        this.idprivilegio = idprivilegio;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    public Menu getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(Menu idelemento) {
        this.idelemento = idelemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprivilegio != null ? idprivilegio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegio)) {
            return false;
        }
        Privilegio other = (Privilegio) object;
        if ((this.idprivilegio == null && other.idprivilegio != null) || (this.idprivilegio != null && !this.idprivilegio.equals(other.idprivilegio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Privilegio[ idprivilegio=" + idprivilegio + " ]";
    }
    
}
