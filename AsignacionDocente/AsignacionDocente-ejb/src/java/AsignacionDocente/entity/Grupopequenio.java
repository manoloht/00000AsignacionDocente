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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "grupopequenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupopequenio.findAll", query = "SELECT g FROM Grupopequenio g")
    , @NamedQuery(name = "Grupopequenio.findById", query = "SELECT g FROM Grupopequenio g WHERE g.id = :id")})
public class Grupopequenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idAsignaturaCA", referencedColumnName = "id")
    @ManyToOne
    private Asignaturaca idAsignaturaCA;
    @OneToMany(mappedBy = "idGrupoPequenio")
    private Collection<Gpdca> gpdcaCollection;

    public Grupopequenio() {
    }

    public Grupopequenio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asignaturaca getIdAsignaturaCA() {
        return idAsignaturaCA;
    }

    public void setIdAsignaturaCA(Asignaturaca idAsignaturaCA) {
        this.idAsignaturaCA = idAsignaturaCA;
    }

    @XmlTransient
    public Collection<Gpdca> getGpdcaCollection() {
        return gpdcaCollection;
    }

    public void setGpdcaCollection(Collection<Gpdca> gpdcaCollection) {
        this.gpdcaCollection = gpdcaCollection;
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
        if (!(object instanceof Grupopequenio)) {
            return false;
        }
        Grupopequenio other = (Grupopequenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Grupopequenio[ id=" + id + " ]";
    }
    
}
