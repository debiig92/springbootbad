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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByNomusuario", query = "SELECT u FROM Usuario u WHERE u.nomusuario = :nomusuario")
    , @NamedQuery(name = "Usuario.findByPassusuario", query = "SELECT u FROM Usuario u WHERE u.passusuario = :passusuario")
    , @NamedQuery(name = "Usuario.findByIdrol", query = "SELECT u FROM Usuario u WHERE u.idrol = :idrol")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private Integer idusuario;
    @Size(max = 100)
    @Column(name = "NOMUSUARIO")
    private String nomusuario;
    @Size(max = 100)
    @Column(name = "PASSUSUARIO")
    private String passusuario;
    @Column(name = "IDROL")
    private Integer idrol;
    @OneToMany(mappedBy = "idusuario")
    private Collection<Autorizacion> autorizacionCollection;
    @OneToMany(mappedBy = "idusuario")
    private Collection<Persona> personaCollection;
    @Column(name="activo")
    private Integer activo;
  /*  @OneToOne(mappedBy = "usuario")
   private Importador importador;*/
    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    
     public void setActivo(Integer activo){
        this.activo=activo;
    }
    
    public Integer getActivo(){
        return activo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public String getPassusuario() {
        return passusuario;
    }

    public void setPassusuario(String passusuario) {
        this.passusuario = passusuario;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    @XmlTransient
    public Collection<Autorizacion> getAutorizacionCollection() {
        return autorizacionCollection;
    }

    public void setAutorizacionCollection(Collection<Autorizacion> autorizacionCollection) {
        this.autorizacionCollection = autorizacionCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

   /* public Importador getImportador() {
        return importador;
    }

    public void setImportador(Importador importador) {
        this.importador = importador;
    }*/

  
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", nomusuario=" + nomusuario + ", passusuario=" + passusuario + ", idrol=" + idrol + ", autorizacionCollection=" + autorizacionCollection + ", personaCollection=" + personaCollection + '}';
    }

  
    
}
