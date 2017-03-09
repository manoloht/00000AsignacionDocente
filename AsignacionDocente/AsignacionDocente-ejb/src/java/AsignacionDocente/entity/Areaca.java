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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "areaca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areaca.findAll", query = "SELECT a FROM Areaca a")
    , @NamedQuery(name = "Areaca.findById", query = "SELECT a FROM Areaca a WHERE a.id = :id")
    , @NamedQuery(name = "Areaca.findByCursoAcademico", query = "SELECT a FROM Areaca a WHERE a.cursoAcademico = :cursoAcademico")})
public class Areaca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cursoAcademico")
    private int cursoAcademico;
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    @ManyToOne
    private Departamento idDepartamento;
    @JoinColumn(name = "idArea", referencedColumnName = "id")
    @ManyToOne
    private Area idArea;
    @OneToMany(mappedBy = "idAreaCA")
    private Collection<Docenteca> docentecaCollection;
    @OneToMany(mappedBy = "idAreaCA")
    private Collection<Asignaturaca> asignaturacaCollection;

    public Areaca() {
    }

    public Areaca(Integer id) {
        this.id = id;
    }

    public Areaca(Integer id, int cursoAcademico) {
        this.id = id;
        this.cursoAcademico = cursoAcademico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(int cursoAcademico) {
        this.cursoAcademico = cursoAcademico;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    @XmlTransient
    public Collection<Docenteca> getDocentecaCollection() {
        return docentecaCollection;
    }

    public void setDocentecaCollection(Collection<Docenteca> docentecaCollection) {
        this.docentecaCollection = docentecaCollection;
    }

    @XmlTransient
    public Collection<Asignaturaca> getAsignaturacaCollection() {
        return asignaturacaCollection;
    }

    public void setAsignaturacaCollection(Collection<Asignaturaca> asignaturacaCollection) {
        this.asignaturacaCollection = asignaturacaCollection;
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
        if (!(object instanceof Areaca)) {
            return false;
        }
        Areaca other = (Areaca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Areaca[ id=" + id + " ]";
    }
    
}
