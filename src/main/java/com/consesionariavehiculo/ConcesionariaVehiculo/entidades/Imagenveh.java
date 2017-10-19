/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Humberto
 */
@Entity
@Table(name = "IMAGENVEH")
public class Imagenveh implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDIMAGENVEH")
    private Integer idimagenveh;
    @JoinColumn(name = "IDTIPOMULTIMEDIA", referencedColumnName = "IDTIPOMULTIMEDIA")
    @ManyToOne
    private Tipomultimedia idtipomultimedia;
    @Lob
    @Column(name = "IMAGEN")
    private byte[] imagen;
    @JoinColumn(name = "IDVEHICULO", referencedColumnName = "IDVEHICULO")
    @ManyToOne
    private Vehiculo idvehiculo;

    public Imagenveh() {
    }

    public Integer getIdimagenveh() {
        return idimagenveh;
    }

    public void setIdimagenveh(Integer idimagenveh) {
        this.idimagenveh = idimagenveh;
    }

   
    public Tipomultimedia getIdtipomultimedia() {
        return idtipomultimedia;
    }

    public void setIdtipomultimedia(Tipomultimedia idtipomultimedia) {
        this.idtipomultimedia = idtipomultimedia;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idimagenveh);
        hash = 37 * hash + Objects.hashCode(this.idtipomultimedia);
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
        final Imagenveh other = (Imagenveh) obj;
        if (!Objects.equals(this.idimagenveh, other.idimagenveh)) {
            return false;
        }
        if (!Objects.equals(this.idtipomultimedia, other.idtipomultimedia)) {
            return false;
        }
        if (!Arrays.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.idvehiculo, other.idvehiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagenveh{" + "idimagenveh=" + idimagenveh + ", idtipomultimedia=" + idtipomultimedia + ", imagen=" + imagen + ", idvehiculo=" + idvehiculo + '}';
    }

 

    
}
