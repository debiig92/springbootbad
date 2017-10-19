/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Humberto
 */
@Entity
@Table(name = "TIPOMULTIMEDIA")
public class Tipomultimedia implements Serializable{
      private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOMULTIMEDIA")
    private Integer idtipomultimedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMTIPOMULTIMEDIA")
    private String nomtipomultimedia;

    public Tipomultimedia() {
    }

    
    public Integer getIdtipomultimedia() {
        return idtipomultimedia;
    }

    public void setIdtipomultimedia(Integer idtipomultimedia) {
        this.idtipomultimedia = idtipomultimedia;
    }

    public String getNomtipomultimedia() {
        return nomtipomultimedia;
    }

    public void setNomtipomultimedia(String nomtipomultimedia) {
        this.nomtipomultimedia = nomtipomultimedia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idtipomultimedia);
        hash = 71 * hash + Objects.hashCode(this.nomtipomultimedia);
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
        final Tipomultimedia other = (Tipomultimedia) obj;
        if (!Objects.equals(this.nomtipomultimedia, other.nomtipomultimedia)) {
            return false;
        }
        if (!Objects.equals(this.idtipomultimedia, other.idtipomultimedia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tipomultimedia{" + "idtipomultimedia=" + idtipomultimedia + '}';
    }
    

}
