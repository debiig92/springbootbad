/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "BODEGUERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodeguero.findAll", query = "SELECT b FROM Bodeguero b")
    , @NamedQuery(name = "Bodeguero.findByIdbodeguero", query = "SELECT b FROM Bodeguero b WHERE b.idbodeguero = :idbodeguero")
    , @NamedQuery(name = "Bodeguero.findByNombodeguero", query = "SELECT b FROM Bodeguero b WHERE b.nombodeguero = :nombodeguero")
    , @NamedQuery(name = "Bodeguero.findByApebodeguero", query = "SELECT b FROM Bodeguero b WHERE b.apebodeguero = :apebodeguero")
    , @NamedQuery(name = "Bodeguero.findByTelbodeguero", query = "SELECT b FROM Bodeguero b WHERE b.telbodeguero = :telbodeguero")
    , @NamedQuery(name = "Bodeguero.findByDirbodeguero", query = "SELECT b FROM Bodeguero b WHERE b.dirbodeguero = :dirbodeguero")})
public class Bodeguero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBODEGUERO")
    private Integer idbodeguero;
    @Size(max = 50)
    @Column(name = "NOMBODEGUERO")
    private String nombodeguero;
    @Size(max = 50)
    @Column(name = "APEBODEGUERO")
    private String apebodeguero;
    @Size(max = 8)
    @Column(name = "TELBODEGUERO")
    private String telbodeguero;
    @Column(name = "DIRBODEGUERO")
    private String dirbodeguero;
    @JoinColumn(name = "IDBODEGA", referencedColumnName = "IDBODEGA")
    @ManyToOne
    private Bodega idbodega;
    @OneToMany(mappedBy = "idbodeguero")
    private Collection<Entsalveh> entsalvehCollection;

    public Bodeguero() {
    }

    public Bodeguero(Integer idbodeguero) {
        this.idbodeguero = idbodeguero;
    }

    public Integer getIdbodeguero() {
        return idbodeguero;
    }

    public void setIdbodeguero(Integer idbodeguero) {
        this.idbodeguero = idbodeguero;
    }

    public String getNombodeguero() {
        return nombodeguero;
    }

    public void setNombodeguero(String nombodeguero) {
        this.nombodeguero = nombodeguero;
    }

    public String getApebodeguero() {
        return apebodeguero;
    }

    public void setApebodeguero(String apebodeguero) {
        this.apebodeguero = apebodeguero;
    }

    public String getTelbodeguero() {
        return telbodeguero;
    }

    public void setTelbodeguero(String telbodeguero) {
        this.telbodeguero = telbodeguero;
    }

    public String getDirbodeguero() {
        return dirbodeguero;
    }

    public void setDirbodeguero(String dirbodeguero) {
        this.dirbodeguero = dirbodeguero;
    }

    public Bodega getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Bodega idbodega) {
        this.idbodega = idbodega;
    }

    @XmlTransient
    public Collection<Entsalveh> getEntsalvehCollection() {
        return entsalvehCollection;
    }

    public void setEntsalvehCollection(Collection<Entsalveh> entsalvehCollection) {
        this.entsalvehCollection = entsalvehCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbodeguero != null ? idbodeguero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodeguero)) {
            return false;
        }
        Bodeguero other = (Bodeguero) object;
        if ((this.idbodeguero == null && other.idbodeguero != null) || (this.idbodeguero != null && !this.idbodeguero.equals(other.idbodeguero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bodeguero[ idbodeguero=" + idbodeguero + " ]";
    }
    
}
