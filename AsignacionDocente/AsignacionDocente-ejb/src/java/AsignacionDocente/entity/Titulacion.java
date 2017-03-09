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
 * @author Manuel
 */
@Entity
@Table(name = "titulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titulacion.findAll", query = "SELECT t FROM Titulacion t")
    , @NamedQuery(name = "Titulacion.findById", query = "SELECT t FROM Titulacion t WHERE t.id = :id")
    , @NamedQuery(name = "Titulacion.findByNombreTitulacion", query = "SELECT t FROM Titulacion t WHERE t.nombreTitulacion = :nombreTitulacion")
    , @NamedQuery(name = "Titulacion.findByPlanEstudios", query = "SELECT t FROM Titulacion t WHERE t.planEstudios = :planEstudios")})
public class Titulacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreTitulacion")
    private String nombreTitulacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planEstudios")
    private int planEstudios;
    @OneToMany(mappedBy = "idTitulacion")
    private Collection<Asignatura> asignaturaCollection;
    @JoinColumn(name = "idCentro", referencedColumnName = "id")
    @ManyToOne
    private Centro idCentro;

    public Titulacion() {
    }

    public Titulacion(Integer id) {
        this.id = id;
    }

    public Titulacion(Integer id, String nombreTitulacion, int planEstudios) {
        this.id = id;
        this.nombreTitulacion = nombreTitulacion;
        this.planEstudios = planEstudios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTitulacion() {
        return nombreTitulacion;
    }

    public void setNombreTitulacion(String nombreTitulacion) {
        this.nombreTitulacion = nombreTitulacion;
    }

    public int getPlanEstudios() {
        return planEstudios;
    }

    public void setPlanEstudios(int planEstudios) {
        this.planEstudios = planEstudios;
    }

    @XmlTransient
    public Collection<Asignatura> getAsignaturaCollection() {
        return asignaturaCollection;
    }

    public void setAsignaturaCollection(Collection<Asignatura> asignaturaCollection) {
        this.asignaturaCollection = asignaturaCollection;
    }

    public Centro getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Centro idCentro) {
        this.idCentro = idCentro;
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
        if (!(object instanceof Titulacion)) {
            return false;
        }
        Titulacion other = (Titulacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Titulacion[ id=" + id + " ]";
    }
    
}
