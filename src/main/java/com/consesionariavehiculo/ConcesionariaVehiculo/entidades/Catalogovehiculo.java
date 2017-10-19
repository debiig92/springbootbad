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
@Table(name = "CATALOGOVEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogovehiculo.findAll", query = "SELECT c FROM Catalogovehiculo c")
    , @NamedQuery(name = "Catalogovehiculo.findByIdcatalogo", query = "SELECT c FROM Catalogovehiculo c WHERE c.idcatalogo = :idcatalogo")})
public class Catalogovehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCATALOGO")
    private Integer idcatalogo;
    @JoinColumn(name = "IDVEHICULO", referencedColumnName = "IDVEHICULO")
    @ManyToOne
    private Vehiculo idvehiculo;
    @JoinColumn(name = "IDENTSALINVE", referencedColumnName = "IDENTSALINVE")
    @ManyToOne
    private Entsalinventario identsalinve;

    public Catalogovehiculo() {
    }

    public Catalogovehiculo(Integer idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public Integer getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(Integer idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Entsalinventario getIdentsalinve() {
        return identsalinve;
    }

    public void setIdentsalinve(Entsalinventario identsalinve) {
        this.identsalinve = identsalinve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatalogo != null ? idcatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogovehiculo)) {
            return false;
        }
        Catalogovehiculo other = (Catalogovehiculo) object;
        if ((this.idcatalogo == null && other.idcatalogo != null) || (this.idcatalogo != null && !this.idcatalogo.equals(other.idcatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Catalogovehiculo[ idcatalogo=" + idcatalogo + " ]";
    }
    
}
