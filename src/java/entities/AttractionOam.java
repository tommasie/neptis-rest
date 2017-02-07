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
@Table(name = "ATTRACTION_OAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttractionOam.findAll", query = "SELECT a FROM AttractionOam a"),
    @NamedQuery(name = "AttractionOam.findByOamId", query = "SELECT a FROM AttractionOam a WHERE a.areaOam.oam.id = :id"),
    @NamedQuery(name = "AttractionOam.findById", query = "SELECT a FROM AttractionOam a WHERE a.id = :id"),
    @NamedQuery(name = "AttractionOam.findByName", query = "SELECT a FROM AttractionOam a WHERE a.name = :name")})
public class AttractionOam implements Serializable {

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
    @OneToMany(mappedBy = "attractionOam")
    private Collection<Tcoda> tcodaCollection;
    @OneToMany(mappedBy = "attractionOam2")
    private Collection<Tmoveat> tmoveatCollection;
    @OneToMany(mappedBy = "attractionOam1")
    private Collection<Tmoveat> tmoveatCollection1;
    @OneToMany(mappedBy = "attractionOam")
    private Collection<Tmoveaa> tmoveaaCollection;
    @JoinColumn(name = "AREA_OAM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AreaOam areaOam;
    @OneToMany(mappedBy = "attractionOam")
    private Collection<Tvisita> tvisitaCollection;

    public AttractionOam() {
    }

    public AttractionOam(Long id) {
        this.id = id;
    }

    public AttractionOam(Long id, String name) {
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

    @XmlTransient
    public Collection<Tmoveaa> getTmoveaaCollection() {
        return tmoveaaCollection;
    }

    public void setTmoveaaCollection(Collection<Tmoveaa> tmoveaaCollection) {
        this.tmoveaaCollection = tmoveaaCollection;
    }

    public AreaOam getAreaOam() {
        return areaOam;
    }

    public void setAreaOam(AreaOam areaOam) {
        this.areaOam = areaOam;
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
        if (!(object instanceof AttractionOam)) {
            return false;
        }
        AttractionOam other = (AttractionOam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AttractionOam[ id=" + id + " ]";
    }
    
}
