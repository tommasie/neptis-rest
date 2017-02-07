/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author tesi
 */
@Entity
@Table(name = "OAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oam.findAll", query = "SELECT o FROM Oam o"),
    @NamedQuery(name = "Oam.findByNameAndCity", query = "SELECT o FROM Oam o WHERE o.name = :name and o.city.id= :cityId"),
    @NamedQuery(name = "Oam.findById", query = "SELECT o FROM Oam o WHERE o.id = :id"),
    @NamedQuery(name = "Oam.findByName", query = "SELECT o FROM Oam o WHERE o.name = :name")})
public class Oam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oam")
    private Collection<AreaOam> areaOamCollection;
    @JoinColumn(name = "CITY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private City city;

    public Oam() {
    }

    public Oam(Long id) {
        this.id = id;
    }

    public Oam(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<AreaOam> getAreaOamCollection() {
        return areaOamCollection;
    }

    public void setAreaOamCollection(Collection<AreaOam> areaOamCollection) {
        this.areaOamCollection = areaOamCollection;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
        if (!(object instanceof Oam)) {
            return false;
        }
        Oam other = (Oam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Oam[ id=" + id + " ]";
    }
    
}
