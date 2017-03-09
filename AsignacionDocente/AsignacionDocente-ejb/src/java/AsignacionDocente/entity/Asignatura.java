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
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findById", query = "SELECT a FROM Asignatura a WHERE a.id = :id")
    , @NamedQuery(name = "Asignatura.findByNombreAsignatura", query = "SELECT a FROM Asignatura a WHERE a.nombreAsignatura = :nombreAsignatura")
    , @NamedQuery(name = "Asignatura.findByTipo", query = "SELECT a FROM Asignatura a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Asignatura.findByCurso", query = "SELECT a FROM Asignatura a WHERE a.curso = :curso")
    , @NamedQuery(name = "Asignatura.findByCreditosGGrande", query = "SELECT a FROM Asignatura a WHERE a.creditosGGrande = :creditosGGrande")
    , @NamedQuery(name = "Asignatura.findByCreditosGMediano", query = "SELECT a FROM Asignatura a WHERE a.creditosGMediano = :creditosGMediano")
    , @NamedQuery(name = "Asignatura.findByCreditosGPequenio", query = "SELECT a FROM Asignatura a WHERE a.creditosGPequenio = :creditosGPequenio")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreAsignatura")
    private String nombreAsignatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "curso")
    private int curso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditosGGrande")
    private double creditosGGrande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditosGMediano")
    private double creditosGMediano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditosGPequenio")
    private double creditosGPequenio;
    @JoinColumn(name = "idTitulacion", referencedColumnName = "id")
    @ManyToOne
    private Titulacion idTitulacion;
    @OneToMany(mappedBy = "idAsignatura")
    private Collection<Asignaturaca> asignaturacaCollection;

    public Asignatura() {
    }

    public Asignatura(Integer id) {
        this.id = id;
    }

    public Asignatura(Integer id, String nombreAsignatura, String tipo, int curso, double creditosGGrande, double creditosGMediano, double creditosGPequenio) {
        this.id = id;
        this.nombreAsignatura = nombreAsignatura;
        this.tipo = tipo;
        this.curso = curso;
        this.creditosGGrande = creditosGGrande;
        this.creditosGMediano = creditosGMediano;
        this.creditosGPequenio = creditosGPequenio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public double getCreditosGGrande() {
        return creditosGGrande;
    }

    public void setCreditosGGrande(double creditosGGrande) {
        this.creditosGGrande = creditosGGrande;
    }

    public double getCreditosGMediano() {
        return creditosGMediano;
    }

    public void setCreditosGMediano(double creditosGMediano) {
        this.creditosGMediano = creditosGMediano;
    }

    public double getCreditosGPequenio() {
        return creditosGPequenio;
    }

    public void setCreditosGPequenio(double creditosGPequenio) {
        this.creditosGPequenio = creditosGPequenio;
    }

    public Titulacion getIdTitulacion() {
        return idTitulacion;
    }

    public void setIdTitulacion(Titulacion idTitulacion) {
        this.idTitulacion = idTitulacion;
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
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Asignatura[ id=" + id + " ]";
    }
    
}
