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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "IMPORTADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importador.findAll", query = "SELECT i FROM Importador i")
    , @NamedQuery(name = "Importador.findByNit", query = "SELECT i FROM Importador i WHERE i.nit = :nit")
    , @NamedQuery(name = "Importador.findByNomimp", query = "SELECT i FROM Importador i WHERE i.nomimp = :nomimp")
    , @NamedQuery(name = "Importador.findByApeimp", query = "SELECT i FROM Importador i WHERE i.apeimp = :apeimp")
    , @NamedQuery(name = "Importador.findByGenimp", query = "SELECT i FROM Importador i WHERE i.genimp = :genimp")
    , @NamedQuery(name = "Importador.findByDirimp", query = "SELECT i FROM Importador i WHERE i.dirimp = :dirimp")
    , @NamedQuery(name = "Importador.findByCorimp", query = "SELECT i FROM Importador i WHERE i.corimp = :corimp")
    , @NamedQuery(name = "Importador.findByNomresp", query = "SELECT i FROM Importador i WHERE i.nomresp = :nomresp")
    , @NamedQuery(name = "Importador.findByAperesp", query = "SELECT i FROM Importador i WHERE i.aperesp = :aperesp")
    , @NamedQuery(name = "Importador.findByTelresp", query = "SELECT i FROM Importador i WHERE i.telresp = :telresp")
    , @NamedQuery(name = "Importador.findByCorresp", query = "SELECT i FROM Importador i WHERE i.corresp = :corresp")
    ,@NamedQuery(name ="Importador.findByIdUsuario", query = "select e from Importador e join fetch e.usuario u where u.idusuario = :idusuario")})
public class Importador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "NIT")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMIMP")
    private String nomimp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APEIMP")
    private String apeimp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENIMP")
    private Character genimp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DIRIMP")
    private String dirimp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORIMP")
    private String corimp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMRESP")
    private String nomresp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APERESP")
    private String aperesp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "TELRESP")
    private String telresp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORRESP")
    private String corresp;
    @OneToMany(mappedBy = "nit")
    private Collection<Rentsalveh> rentsalvehCollection;
    @OneToMany(mappedBy = "nit")
    private Collection<Contactoimportador> contactoimportadorCollection;
    @OneToMany(mappedBy = "nit")
    private Collection<Importacion> importacionCollection; 
    @OneToOne
    @JoinColumn(name = "IDUSUARIO")
    private Usuario usuario;
    public Importador() {
    }

    public Importador(String nit) {
        this.nit = nit;
    }

    public Importador(String nit, String nomimp, String apeimp, Character genimp, String dirimp, String corimp, String nomresp, String aperesp, String telresp, String corresp, Usuario idusuario) {
        this.nit = nit;
        this.nomimp = nomimp;
        this.apeimp = apeimp;
        this.genimp = genimp;
        this.dirimp = dirimp;
        this.corimp = corimp;
        this.nomresp = nomresp;
        this.aperesp = aperesp;
        this.telresp = telresp;
        this.corresp = corresp;
        this.usuario=idusuario;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNomimp() {
        return nomimp;
    }

    public void setNomimp(String nomimp) {
        this.nomimp = nomimp;
    }

    public String getApeimp() {
        return apeimp;
    }

    public void setApeimp(String apeimp) {
        this.apeimp = apeimp;
    }

    public Character getGenimp() {
        return genimp;
    }

    public void setGenimp(Character genimp) {
        this.genimp = genimp;
    }

    public String getDirimp() {
        return dirimp;
    }

    public void setDirimp(String dirimp) {
        this.dirimp = dirimp;
    }

    public String getCorimp() {
        return corimp;
    }

    public void setCorimp(String corimp) {
        this.corimp = corimp;
    }

    public String getNomresp() {
        return nomresp;
    }

    public void setNomresp(String nomresp) {
        this.nomresp = nomresp;
    }

    public String getAperesp() {
        return aperesp;
    }

    public void setAperesp(String aperesp) {
        this.aperesp = aperesp;
    }

    public String getTelresp() {
        return telresp;
    }

    public void setTelresp(String telresp) {
        this.telresp = telresp;
    }

    public String getCorresp() {
        return corresp;
    }

    public void setCorresp(String corresp) {
        this.corresp = corresp;
    }

    @XmlTransient
    public Collection<Rentsalveh> getRentsalvehCollection() {
        return rentsalvehCollection;
    }

    public void setRentsalvehCollection(Collection<Rentsalveh> rentsalvehCollection) {
        this.rentsalvehCollection = rentsalvehCollection;
    }

    @XmlTransient
    public Collection<Contactoimportador> getContactoimportadorCollection() {
        return contactoimportadorCollection;
    }

    public void setContactoimportadorCollection(Collection<Contactoimportador> contactoimportadorCollection) {
        this.contactoimportadorCollection = contactoimportadorCollection;
    }

    @XmlTransient
    public Collection<Importacion> getImportacionCollection() {
        return importacionCollection;
    }

    public void setImportacionCollection(Collection<Importacion> importacionCollection) {
        this.importacionCollection = importacionCollection;
    }
 
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario idusuario) {
        this.usuario = idusuario;
    }
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Importador)) {
            return false;
        }
        Importador other = (Importador) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Importador{" + "nit=" + nit + ", nomimp=" + nomimp + ", apeimp=" + apeimp + ", genimp=" + genimp + ", dirimp=" + dirimp + ", corimp=" + corimp + ", nomresp=" + nomresp + ", aperesp=" + aperesp + ", telresp=" + telresp + ", corresp=" + corresp + ", rentsalvehCollection=" + rentsalvehCollection + ", contactoimportadorCollection=" + contactoimportadorCollection + ", importacionCollection=" + importacionCollection + ", usuario=" + usuario + '}';
    }

  
}
