/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author tesi
 */
@Entity
@Table(name = "ATTRACTION_C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttractionC.findAll", query = "SELECT a FROM AttractionC a"),
    @NamedQuery(name = "AttractionC.findByCityId", query = "SELECT a FROM AttractionC a WHERE a.city.id = :id"),
    @NamedQuery(name = "AttractionC.findById", query = "SELECT a FROM AttractionC a WHERE a.id = :id"),
    @NamedQuery(name = "AttractionC.findByName", query = "SELECT a FROM AttractionC a WHERE a.name = :name")})
public class AttractionC implements Serializable {

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
    @Size(min = 1, max = 10)
    @NotNull
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @NotNull
    @Column(name = "LONGITUDE")
    private String longitude;
    @OneToMany(mappedBy = "attractionC")
    private Collection<Tcoda> tcodaCollection;
    @OneToMany(mappedBy = "attractionC2")
    private Collection<Tmoveat> tmoveatCollection;
    @OneToMany(mappedBy = "attractionC1")
    private Collection<Tmoveat> tmoveatCollection1;
    @JoinColumn(name = "CITY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private City city;
    @OneToMany(mappedBy = "attractionC")
    private Collection<Tmoveaa> tmoveaaCollection;
    @OneToMany(mappedBy = "attractionC")
    private Collection<Tvisita> tvisitaCollection;

    public AttractionC() {
    }

    public AttractionC(Long id) {
        this.id = id;
    }

    public AttractionC(Long id, String name) {
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @XmlTransient
    public Collection<Tcoda> getTcodaCollection() {
        return tcodaCollection;
    }

    public void setTcodaCollection(Collection<Tcoda> tcodaCollection) {
        this.tcodaCollection = tcodaCollection;
    }

    @XmlTransient
    public Collection<Tmoveat> getTmoveatCollection() {
        return tmoveatCollection;
    }

    public void setTmoveatCollection(Collection<Tmoveat> tmoveatCollection) {
        this.tmoveatCollection = tmoveatCollection;
    }

    @XmlTransient
    public Collection<Tmoveat> getTmoveatCollection1() {
        return tmoveatCollection1;
    }

    public void setTmoveatCollection1(Collection<Tmoveat> tmoveatCollection1) {
        this.tmoveatCollection1 = tmoveatCollection1;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Tmoveaa> getTmoveaaCollection() {
        return tmoveaaCollection;
    }

    public void setTmoveaaCollection(Collection<Tmoveaa> tmoveaaCollection) {
        this.tmoveaaCollection = tmoveaaCollection;
    }

    @XmlTransient
    public Collection<Tvisita> getTvisitaCollection() {
        return tvisitaCollection;
    }

    public void setTvisitaCollection(Collection<Tvisita> tvisitaCollection) {
        this.tvisitaCollection = tvisitaCollection;
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
        if (!(object instanceof AttractionC)) {
            return false;
        }
        AttractionC other = (AttractionC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AttractionC[ id=" + id + " ]";
    }
    
}
