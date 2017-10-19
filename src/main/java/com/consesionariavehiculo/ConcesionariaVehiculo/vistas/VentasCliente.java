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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Humberto
 */
@Entity
@Table(name = "ventascliente") // VISTA VENTASCLIENTE
public class VentasCliente implements Serializable{
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
    @Column(name = "DUICLIENTE")
    private String duicliente;
    @Column(name = "ENTREGADO")
    private Integer entregado;
    @Column(name = "IDUSUARIO")
    private Integer idusuario;
    @Column(name = "NOMMODEL")
    private String nommodelo;
    @Column(name = "NOMMARCA")
    private String nommarca;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "APECLIENTE")
    private String apecliente;
    @Column(name = "NOMCLIENTE")
    private String nomcliente;

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

    public String getDuicliente() {
        return duicliente;
    }

    public void setDuicliente(String duicliente) {
        this.duicliente = duicliente;
    }

    public Integer getEntregado() {
        return entregado;
    }

    public void setEntregado(Integer entregado) {
        this.entregado = entregado;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNommodelo() {
        return nommodelo;
    }

    public void setNommodelo(String nommodelo) {
        this.nommodelo = nommodelo;
    }

    public String getNommarca() {
        return nommarca;
    }

    public void setNommarca(String nommarca) {
        this.nommarca = nommarca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getApecliente() {
        return apecliente;
    }

    public void setApecliente(String apecliente) {
        this.apecliente = apecliente;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idclienteveh);
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
        final VentasCliente other = (VentasCliente) obj;
        if (!Objects.equals(this.idclienteveh, other.idclienteveh)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VentasCliente{" + "idclienteveh=" + idclienteveh + '}';
    }
    
    
}
