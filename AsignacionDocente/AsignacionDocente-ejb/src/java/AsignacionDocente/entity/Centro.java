/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsignacionDocente.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Manuel
 */
@Entity
@Table(name = "centro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centro.findAll", query = "SELECT c FROM Centro c")
    , @NamedQuery(name = "Centro.findById", query = "SELECT c FROM Centro c WHERE c.id = :id")
    , @NamedQuery(name = "Centro.findByNombreCentro", query = "SELECT c FROM Centro c WHERE c.nombreCentro = :nombreCentro")
    , @NamedQuery(name = "Centro.findByPaginaWeb", query = "SELECT c FROM Centro c WHERE c.paginaWeb = :paginaWeb")
    , @NamedQuery(name = "Centro.findByTelefono", query = "SELECT c FROM Centro c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Centro.findByMaps", query = "SELECT c FROM Centro c WHERE c.maps = :maps")})
public class Centro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreCentro")
    private String nombreCentro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "paginaWeb")
    private String paginaWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "maps")
    private String maps;
    @OneToMany(mappedBy = "idCentro")
    private Collection<Titulacion> titulacionCollection;

    public Centro() {
    }

    public Centro(Integer id) {
        this.id = id;
    }

    public Centro(Integer id, String nombreCentro, String paginaWeb, int telefono, String maps) {
        this.id = id;
        this.nombreCentro = nombreCentro;
        this.paginaWeb = paginaWeb;
        this.telefono = telefono;
        this.maps = maps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    @XmlTransient
    public Collection<Titulacion> getTitulacionCollection() {
        return titulacionCollection;
    }

    public void setTitulacionCollection(Collection<Titulacion> titulacionCollection) {
        this.titulacionCollection = titulacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centro)) {
            return false;
        }
        Centro other = (Centro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Centro[ id=" + id + " ]";
    }
    
}
