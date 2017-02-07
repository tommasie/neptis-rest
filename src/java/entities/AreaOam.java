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
@Table(name = "AREA_OAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaOam.findAll", query = "SELECT a FROM AreaOam a"),
    @NamedQuery(name = "AreaOam.findById", query = "SELECT a FROM AreaOam a WHERE a.id = :id"),
    @NamedQuery(name = "AreaOam.findByNameAndMuseum", query = "SELECT a FROM AreaOam a WHERE a.name = :name and a.oam.id= :museum"),

    @NamedQuery(name = "AreaOam.findByMuseum", query = "SELECT a FROM AreaOam a WHERE a.oam.id = :museumId"),

    @NamedQuery(name = "AreaOam.findByName", query = "SELECT a FROM AreaOam a WHERE a.name = :name")})
public class AreaOam implements Serializable {

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
    @OneToMany(mappedBy = "areaOam")
    private Collection<Tcoda> tcodaCollection;
    @JoinColumn(name = "OAM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Oam oam;
    @OneToMany(mappedBy = "areaOam2")
    private Collection<Tmovear> tmovearCollection;
    @OneToMany(mappedBy = "areaOam1")
    private Collection<Tmovear> tmovearCollection1;
    @OneToMany(mappedBy = "areaOam")
    private Collection<Tmoveaa> tmoveaaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaOam")
    private Collection<AttractionOam> attractionOamCollection;

    public AreaOam() {
    }

    public AreaOam(Long id) {
        this.id = id;
    }

    public AreaOam(Long id, String name) {
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

    public Oam getOam() {
        return oam;
    }

    public void setOam(Oam oam) {
        this.oam = oam;
    }

    @XmlTransient
    public Collection<Tmovear> getTmovearCollection() {
        return tmovearCollection;
    }

    public void setTmovearCollection(Collection<Tmovear> tmovearCollection) {
        this.tmovearCollection = tmovearCollection;
    }

    @XmlTransient
    public Collection<Tmovear> getTmovearCollection1() {
        return tmovearCollection1;
    }

    public void setTmovearCollection1(Collection<Tmovear> tmovearCollection1) {
        this.tmovearCollection1 = tmovearCollection1;
    }

    @XmlTransient
    public Collection<Tmoveaa> getTmoveaaCollection() {
        return tmoveaaCollection;
    }

    public void setTmoveaaCollection(Collection<Tmoveaa> tmoveaaCollection) {
        this.tmoveaaCollection = tmoveaaCollection;
    }

    @XmlTransient
    public Collection<AttractionOam> getAttractionOamCollection() {
        return attractionOamCollection;
    }

    public void setAttractionOamCollection(Collection<AttractionOam> attractionOamCollection) {
        this.attractionOamCollection = attractionOamCollection;
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
        if (!(object instanceof AreaOam)) {
            return false;
        }
        AreaOam other = (AreaOam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AreaOam[ id=" + id + " ]";
    }
    
}
