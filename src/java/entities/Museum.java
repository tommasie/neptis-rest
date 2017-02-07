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
@Table(name = "MUSEUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Museum.findAll", query = "SELECT m FROM Museum m"),
    @NamedQuery(name = "Museum.findByNameAndCity", query = "SELECT m FROM Museum m WHERE m.name = :name and m.city.id= :city"),
    @NamedQuery(name = "Museum.findById", query = "SELECT m FROM Museum m WHERE m.id = :id"),
    @NamedQuery(name = "Museum.findByName", query = "SELECT m FROM Museum m WHERE m.name = :name")})
public class Museum implements Serializable {

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
    @JoinColumn(name = "CITY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private City city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "museum")
    private Collection<AreaM> areaMCollection;

    public Museum() {
    }

    public Museum(Long id) {
        this.id = id;
    }

    public Museum(Long id, String name) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<AreaM> getAreaMCollection() {
        return areaMCollection;
    }

    public void setAreaMCollection(Collection<AreaM> areaMCollection) {
        this.areaMCollection = areaMCollection;
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
        if (!(object instanceof Museum)) {
            return false;
        }
        Museum other = (Museum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Museum[ id=" + id + " ]";
    }
    
}
