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
@Table(name = "docenteca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docenteca.findAll", query = "SELECT d FROM Docenteca d")
    , @NamedQuery(name = "Docenteca.findById", query = "SELECT d FROM Docenteca d WHERE d.id = :id")
    , @NamedQuery(name = "Docenteca.findByCursoAcademico", query = "SELECT d FROM Docenteca d WHERE d.cursoAcademico = :cursoAcademico")
    , @NamedQuery(name = "Docenteca.findByAntiguedad", query = "SELECT d FROM Docenteca d WHERE d.antiguedad = :antiguedad")
    , @NamedQuery(name = "Docenteca.findByCreditos", query = "SELECT d FROM Docenteca d WHERE d.creditos = :creditos")
    , @NamedQuery(name = "Docenteca.findByActivo", query = "SELECT d FROM Docenteca d WHERE d.activo = :activo")
    , @NamedQuery(name = "Docenteca.findByCierreCreditos", query = "SELECT d FROM Docenteca d WHERE d.cierreCreditos = :cierreCreditos")
    , @NamedQuery(name = "Docenteca.findByReduccion", query = "SELECT d FROM Docenteca d WHERE d.reduccion = :reduccion")})
public class Docenteca implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "antiguedad")
    private int antiguedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditos")
    private int creditos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cierreCreditos")
    private boolean cierreCreditos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reduccion")
    private int reduccion;
    @OneToMany(mappedBy = "idDocenteCA")
    private Collection<Gmdca> gmdcaCollection;
    @OneToMany(mappedBy = "idDocenteCA")
    private Collection<Gpdca> gpdcaCollection;
    @JoinColumn(name = "idCategoriaProfesional", referencedColumnName = "id")
    @ManyToOne
    private Categoriaprofesional idCategoriaProfesional;
    @JoinColumn(name = "idAreaCA", referencedColumnName = "id")
    @ManyToOne
    private Areaca idAreaCA;
    @JoinColumn(name = "idDocente", referencedColumnName = "id")
    @ManyToOne
    private Docente idDocente;
    @OneToMany(mappedBy = "idDocenteCA")
    private Collection<Ggdca> ggdcaCollection;

    public Docenteca() {
    }

    public Docenteca(Integer id) {
        this.id = id;
    }

    public Docenteca(Integer id, int cursoAcademico, int antiguedad, int creditos, boolean activo, boolean cierreCreditos, int reduccion) {
        this.id = id;
        this.cursoAcademico = cursoAcademico;
        this.antiguedad = antiguedad;
        this.creditos = creditos;
        this.activo = activo;
        this.cierreCreditos = cierreCreditos;
        this.reduccion = reduccion;
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getCierreCreditos() {
        return cierreCreditos;
    }

    public void setCierreCreditos(boolean cierreCreditos) {
        this.cierreCreditos = cierreCreditos;
    }

    public int getReduccion() {
        return reduccion;
    }

    public void setReduccion(int reduccion) {
        this.reduccion = reduccion;
    }

    @XmlTransient
    public Collection<Gmdca> getGmdcaCollection() {
        return gmdcaCollection;
    }

    public void setGmdcaCollection(Collection<Gmdca> gmdcaCollection) {
        this.gmdcaCollection = gmdcaCollection;
    }

    @XmlTransient
    public Collection<Gpdca> getGpdcaCollection() {
        return gpdcaCollection;
    }

    public void setGpdcaCollection(Collection<Gpdca> gpdcaCollection) {
        this.gpdcaCollection = gpdcaCollection;
    }

    public Categoriaprofesional getIdCategoriaProfesional() {
        return idCategoriaProfesional;
    }

    public void setIdCategoriaProfesional(Categoriaprofesional idCategoriaProfesional) {
        this.idCategoriaProfesional = idCategoriaProfesional;
    }

    public Areaca getIdAreaCA() {
        return idAreaCA;
    }

    public void setIdAreaCA(Areaca idAreaCA) {
        this.idAreaCA = idAreaCA;
    }

    public Docente getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docente idDocente) {
        this.idDocente = idDocente;
    }

    @XmlTransient
    public Collection<Ggdca> getGgdcaCollection() {
        return ggdcaCollection;
    }

    public void setGgdcaCollection(Collection<Ggdca> ggdcaCollection) {
        this.ggdcaCollection = ggdcaCollection;
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
        if (!(object instanceof Docenteca)) {
            return false;
        }
        Docenteca other = (Docenteca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Docenteca[ id=" + id + " ]";
    }
    
}
