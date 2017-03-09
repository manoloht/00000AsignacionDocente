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
@Table(name = "categoriaprofesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriaprofesional.findAll", query = "SELECT c FROM Categoriaprofesional c")
    , @NamedQuery(name = "Categoriaprofesional.findById", query = "SELECT c FROM Categoriaprofesional c WHERE c.id = :id")
    , @NamedQuery(name = "Categoriaprofesional.findByNombre", query = "SELECT c FROM Categoriaprofesional c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Categoriaprofesional.findByReduccion", query = "SELECT c FROM Categoriaprofesional c WHERE c.reduccion = :reduccion")
    , @NamedQuery(name = "Categoriaprofesional.findByOrden", query = "SELECT c FROM Categoriaprofesional c WHERE c.orden = :orden")})
public class Categoriaprofesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reduccion")
    private int reduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;
    @OneToMany(mappedBy = "idCategoriaProfesional")
    private Collection<Docenteca> docentecaCollection;

    public Categoriaprofesional() {
    }

    public Categoriaprofesional(Integer id) {
        this.id = id;
    }

    public Categoriaprofesional(Integer id, String nombre, int reduccion, int orden) {
        this.id = id;
        this.nombre = nombre;
        this.reduccion = reduccion;
        this.orden = orden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getReduccion() {
        return reduccion;
    }

    public void setReduccion(int reduccion) {
        this.reduccion = reduccion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @XmlTransient
    public Collection<Docenteca> getDocentecaCollection() {
        return docentecaCollection;
    }

    public void setDocentecaCollection(Collection<Docenteca> docentecaCollection) {
        this.docentecaCollection = docentecaCollection;
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
        if (!(object instanceof Categoriaprofesional)) {
            return false;
        }
        Categoriaprofesional other = (Categoriaprofesional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Categoriaprofesional[ id=" + id + " ]";
    }
    
}
