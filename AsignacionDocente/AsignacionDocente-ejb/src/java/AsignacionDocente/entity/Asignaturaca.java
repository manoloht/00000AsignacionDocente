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
@Table(name = "asignaturaca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturaca.findAll", query = "SELECT a FROM Asignaturaca a")
    , @NamedQuery(name = "Asignaturaca.findById", query = "SELECT a FROM Asignaturaca a WHERE a.id = :id")
    , @NamedQuery(name = "Asignaturaca.findByCreditosGGrande", query = "SELECT a FROM Asignaturaca a WHERE a.creditosGGrande = :creditosGGrande")
    , @NamedQuery(name = "Asignaturaca.findByCreditosGMediano", query = "SELECT a FROM Asignaturaca a WHERE a.creditosGMediano = :creditosGMediano")
    , @NamedQuery(name = "Asignaturaca.findByCreditosGPequenio", query = "SELECT a FROM Asignaturaca a WHERE a.creditosGPequenio = :creditosGPequenio")
    , @NamedQuery(name = "Asignaturaca.findByUbicacionTemporal", query = "SELECT a FROM Asignaturaca a WHERE a.ubicacionTemporal = :ubicacionTemporal")})
public class Asignaturaca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ubicacionTemporal")
    private String ubicacionTemporal;
    @OneToMany(mappedBy = "idAsignaturaCA")
    private Collection<Grupopequenio> grupopequenioCollection;
    @OneToMany(mappedBy = "idAsignaturaCA")
    private Collection<Grupogrande> grupograndeCollection;
    @JoinColumn(name = "idAsignatura", referencedColumnName = "id")
    @ManyToOne
    private Asignatura idAsignatura;
    @JoinColumn(name = "idAreaCA", referencedColumnName = "id")
    @ManyToOne
    private Areaca idAreaCA;
    @OneToMany(mappedBy = "idAsignaturaCA")
    private Collection<Grupomediano> grupomedianoCollection;

    public Asignaturaca() {
    }

    public Asignaturaca(Integer id) {
        this.id = id;
    }

    public Asignaturaca(Integer id, double creditosGGrande, double creditosGMediano, double creditosGPequenio, String ubicacionTemporal) {
        this.id = id;
        this.creditosGGrande = creditosGGrande;
        this.creditosGMediano = creditosGMediano;
        this.creditosGPequenio = creditosGPequenio;
        this.ubicacionTemporal = ubicacionTemporal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUbicacionTemporal() {
        return ubicacionTemporal;
    }

    public void setUbicacionTemporal(String ubicacionTemporal) {
        this.ubicacionTemporal = ubicacionTemporal;
    }

    @XmlTransient
    public Collection<Grupopequenio> getGrupopequenioCollection() {
        return grupopequenioCollection;
    }

    public void setGrupopequenioCollection(Collection<Grupopequenio> grupopequenioCollection) {
        this.grupopequenioCollection = grupopequenioCollection;
    }

    @XmlTransient
    public Collection<Grupogrande> getGrupograndeCollection() {
        return grupograndeCollection;
    }

    public void setGrupograndeCollection(Collection<Grupogrande> grupograndeCollection) {
        this.grupograndeCollection = grupograndeCollection;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Areaca getIdAreaCA() {
        return idAreaCA;
    }

    public void setIdAreaCA(Areaca idAreaCA) {
        this.idAreaCA = idAreaCA;
    }

    @XmlTransient
    public Collection<Grupomediano> getGrupomedianoCollection() {
        return grupomedianoCollection;
    }

    public void setGrupomedianoCollection(Collection<Grupomediano> grupomedianoCollection) {
        this.grupomedianoCollection = grupomedianoCollection;
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
        if (!(object instanceof Asignaturaca)) {
            return false;
        }
        Asignaturaca other = (Asignaturaca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Asignaturaca[ id=" + id + " ]";
    }
    
}
