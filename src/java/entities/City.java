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
@Table(name = "CITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
    @NamedQuery(name = "City.findByNameAndRegion", query = "SELECT c FROM City c WHERE c.name = :name and c.region = :region"),
    @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
    @NamedQuery(name = "City.findByRegion", query = "SELECT c FROM City c WHERE c.region = :region")})
public class City implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "REGION")
    private String region;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Collection<Museum> museumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Collection<AttractionC> attractionCCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Collection<Oam> oamCollection;

    public City() {
    }

    public City(Long id) {
        this.id = id;
    }

    public City(Long id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlTransient
    public Collection<Museum> getMuseumCollection() {
        return museumCollection;
    }

    public void setMuseumCollection(Collection<Museum> museumCollection) {
        this.museumCollection = museumCollection;
    }

    @XmlTransient
    public Collection<AttractionC> getAttractionCCollection() {
        return attractionCCollection;
    }

    public void setAttractionCCollection(Collection<AttractionC> attractionCCollection) {
        this.attractionCCollection = attractionCCollection;
    }

    @XmlTransient
    public Collection<Oam> getOamCollection() {
        return oamCollection;
    }

    public void setOamCollection(Collection<Oam> oamCollection) {
        this.oamCollection = oamCollection;
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
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.City[ id=" + id + " ]";
    }
    
}
