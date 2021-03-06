/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsignacionDocente.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "gpdca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gpdca.findAll", query = "SELECT g FROM Gpdca g")
    , @NamedQuery(name = "Gpdca.findById", query = "SELECT g FROM Gpdca g WHERE g.id = :id")
    , @NamedQuery(name = "Gpdca.findByCreditosSolicitados", query = "SELECT g FROM Gpdca g WHERE g.creditosSolicitados = :creditosSolicitados")
    , @NamedQuery(name = "Gpdca.findByCreditosAsignados", query = "SELECT g FROM Gpdca g WHERE g.creditosAsignados = :creditosAsignados")})
public class Gpdca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditosSolicitados")
    private double creditosSolicitados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditosAsignados")
    private double creditosAsignados;
    @JoinColumn(name = "idDocenteCA", referencedColumnName = "id")
    @ManyToOne
    private Docenteca idDocenteCA;
    @JoinColumn(name = "idGrupoPequenio", referencedColumnName = "id")
    @ManyToOne
    private Grupopequenio idGrupoPequenio;

    public Gpdca() {
    }

    public Gpdca(Integer id) {
        this.id = id;
    }

    public Gpdca(Integer id, double creditosSolicitados, double creditosAsignados) {
        this.id = id;
        this.creditosSolicitados = creditosSolicitados;
        this.creditosAsignados = creditosAsignados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCreditosSolicitados() {
        return creditosSolicitados;
    }

    public void setCreditosSolicitados(double creditosSolicitados) {
        this.creditosSolicitados = creditosSolicitados;
    }

    public double getCreditosAsignados() {
        return creditosAsignados;
    }

    public void setCreditosAsignados(double creditosAsignados) {
        this.creditosAsignados = creditosAsignados;
    }

    public Docenteca getIdDocenteCA() {
        return idDocenteCA;
    }

    public void setIdDocenteCA(Docenteca idDocenteCA) {
        this.idDocenteCA = idDocenteCA;
    }

    public Grupopequenio getIdGrupoPequenio() {
        return idGrupoPequenio;
    }

    public void setIdGrupoPequenio(Grupopequenio idGrupoPequenio) {
        this.idGrupoPequenio = idGrupoPequenio;
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
        if (!(object instanceof Gpdca)) {
            return false;
        }
        Gpdca other = (Gpdca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Gpdca[ id=" + id + " ]";
    }
    
}
