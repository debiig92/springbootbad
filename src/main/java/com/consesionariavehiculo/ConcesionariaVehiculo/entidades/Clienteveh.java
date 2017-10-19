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
@Table(name = "CLIENTEVEH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteveh.findAll", query = "SELECT c FROM Clienteveh c")
    , @NamedQuery(name = "Clienteveh.findByIdclienteveh", query = "SELECT c FROM Clienteveh c WHERE c.idclienteveh = :idclienteveh")
    , @NamedQuery(name = "Clienteveh.findByFechacompra", query = "SELECT c FROM Clienteveh c WHERE c.fechacompra = :fechacompra")})
public class Clienteveh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENTEVEH")
    private Integer idclienteveh;
    @Column(name = "FECHACOMPRA")
    @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechacompra;
    @JoinColumn(name = "IDVEHICULO", referencedColumnName = "IDVEHICULO")
    @ManyToOne
    private Vehiculo idvehiculo;
    @JoinColumn(name = "DUICLIENTE", referencedColumnName = "DUICLIENTE")
    @ManyToOne
    private Cliente duicliente;

    @Column(name = "ENTREGADO")
    private Integer entregado;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;
    
    public Clienteveh() {
    }

    public Clienteveh(Integer idclienteveh) {
        this.idclienteveh = idclienteveh;
    }

    public Integer getIdclienteveh() {
        return idclienteveh;
    }

    public void setIdclienteveh(Integer idclienteveh) {
        this.idclienteveh = idclienteveh;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Cliente getDuicliente() {
        return duicliente;
    }

    public void setDuicliente(Cliente duicliente) {
        this.duicliente = duicliente;
    }

    public Integer getEntregado() {
        return entregado;
    }

    public void setEntregado(Integer entregado) {
        this.entregado = entregado;
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
        hash += (idclienteveh != null ? idclienteveh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteveh)) {
            return false;
        }
        Clienteveh other = (Clienteveh) object;
        if ((this.idclienteveh == null && other.idclienteveh != null) || (this.idclienteveh != null && !this.idclienteveh.equals(other.idclienteveh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Clienteveh[ idclienteveh=" + idclienteveh + " ]";
    }
    
}
