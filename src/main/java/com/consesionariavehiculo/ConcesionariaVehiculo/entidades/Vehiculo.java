/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "VEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIdvehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idvehiculo = :idvehiculo")
    , @NamedQuery(name = "Vehiculo.findByIdestado", query = "SELECT v FROM Vehiculo v WHERE v.idestado = :idestado")
    , @NamedQuery(name = "Vehiculo.findByIdmodelo", query = "SELECT v FROM Vehiculo v WHERE v.idmodelo = :idmodelo")
    , @NamedQuery(name = "Vehiculo.findByAnio", query = "SELECT v FROM Vehiculo v WHERE v.anio = :anio")
    , @NamedQuery(name = "Vehiculo.findByIdimport", query = "SELECT v FROM Vehiculo v WHERE v.idimport = :idimport")
    , @NamedQuery(name = "Vehiculo.findByPreciosalida", query = "SELECT v FROM Vehiculo v WHERE v.preciosalida = :preciosalida")
    , @NamedQuery(name = "Vehiculo.findByCostoinicial", query = "SELECT v FROM Vehiculo v WHERE v.costoinicial = :costoinicial")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVEHICULO")
    private Integer idvehiculo;
    @JoinColumn(name = "IDESTADO", referencedColumnName = "IDESTADO")
    @ManyToOne
    private Estado idestado;
    @JoinColumn(name = "IDMODELO", referencedColumnName = "IDMODELO")
    @ManyToOne
    private Modelo idmodelo;
    @Column(name = "ANIO")
    private Integer anio;
    @JoinColumn(name = "IDIMPORT", referencedColumnName = "IDIMPORT")
    @ManyToOne
    private Importacion idimport;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIOSALIDA")
    private BigDecimal preciosalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTOINICIAL")
    private BigDecimal costoinicial;
    @Column(name = "costoacumulado")
    private BigDecimal costoacumulado;
    @OneToMany(mappedBy = "idvehiculo")
    private Collection<Rentsalveh> rentsalvehCollection;
    @OneToMany(mappedBy = "idvehiculo")
    private Collection<Multimediaveh> multimediavehCollection;
    @OneToMany(mappedBy = "idvehiculo")
    private Collection<Detallevehdef> detallevehdefCollection;
    @OneToMany(mappedBy = "idvehiculo")
    private Collection<Catalogovehiculo> catalogovehiculoCollection;
    @OneToMany(mappedBy = "idvehiculo")
    private Collection<Clienteveh> clientevehCollection;
    @OneToMany(mappedBy = "idvehiculo")
    private Collection<Respaveh> respavehCollection;

    public Vehiculo() {
    }

    public Vehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Vehiculo(Integer idvehiculo, BigDecimal costoinicial) {
        this.idvehiculo = idvehiculo;
        this.costoinicial = costoinicial;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    

    public Modelo getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Modelo idmodelo) {
        this.idmodelo = idmodelo;
    }


    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Importacion getIdimport() {
        return idimport;
    }

    public void setIdimport(Importacion idimport) {
        this.idimport = idimport;
    }

 
    public BigDecimal getPreciosalida() {
        return preciosalida;
    }

    public void setPreciosalida(BigDecimal preciosalida) {
        this.preciosalida = preciosalida;
    }

    public BigDecimal getCostoinicial() {
        return costoinicial;
    }

    public void setCostoinicial(BigDecimal costoinicial) {
        this.costoinicial = costoinicial;
    }

    public BigDecimal getCostoacumulado() {
        return costoacumulado;
    }

    public void setCostoacumulado(BigDecimal costoacumulado) {
        this.costoacumulado = costoacumulado;
    }

    
    @XmlTransient
    public Collection<Rentsalveh> getRentsalvehCollection() {
        return rentsalvehCollection;
    }

    public void setRentsalvehCollection(Collection<Rentsalveh> rentsalvehCollection) {
        this.rentsalvehCollection = rentsalvehCollection;
    }

    @XmlTransient
    public Collection<Multimediaveh> getMultimediavehCollection() {
        return multimediavehCollection;
    }

    public void setMultimediavehCollection(Collection<Multimediaveh> multimediavehCollection) {
        this.multimediavehCollection = multimediavehCollection;
    }

    @XmlTransient
    public Collection<Detallevehdef> getDetallevehdefCollection() {
        return detallevehdefCollection;
    }

    public void setDetallevehdefCollection(Collection<Detallevehdef> detallevehdefCollection) {
        this.detallevehdefCollection = detallevehdefCollection;
    }

    @XmlTransient
    public Collection<Catalogovehiculo> getCatalogovehiculoCollection() {
        return catalogovehiculoCollection;
    }

    public void setCatalogovehiculoCollection(Collection<Catalogovehiculo> catalogovehiculoCollection) {
        this.catalogovehiculoCollection = catalogovehiculoCollection;
    }

    @XmlTransient
    public Collection<Clienteveh> getClientevehCollection() {
        return clientevehCollection;
    }

    public void setClientevehCollection(Collection<Clienteveh> clientevehCollection) {
        this.clientevehCollection = clientevehCollection;
    }

    @XmlTransient
    public Collection<Respaveh> getRespavehCollection() {
        return respavehCollection;
    }

    public void setRespavehCollection(Collection<Respaveh> respavehCollection) {
        this.respavehCollection = respavehCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehiculo != null ? idvehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idvehiculo == null && other.idvehiculo != null) || (this.idvehiculo != null && !this.idvehiculo.equals(other.idvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vehiculo[ idvehiculo=" + idvehiculo + " ]";
    }
    
}
