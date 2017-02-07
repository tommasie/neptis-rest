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
@Table(name = "AREA_M")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaM.findAll", query = "SELECT a FROM AreaM a"),
    @NamedQuery(name = "AreaM.findByMuseum", query = "SELECT a FROM AreaM a WHERE a.museum.id = :museumId"),
    @NamedQuery(name = "AreaM.findByNameAndMuseum", query = "SELECT a FROM AreaM a WHERE a.name = :name and a.museum.id= :museum"),
    @NamedQuery(name = "AreaM.findById", query = "SELECT a FROM AreaM a WHERE a.id = :id"),
    @NamedQuery(name = "AreaM.findByName", query = "SELECT a FROM AreaM a WHERE a.name = :name")})
public class AreaM implements Serializable {

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
    @OneToMany(mappedBy = "areaM")
    private Collection<Tcoda> tcodaCollection;
    @OneToMany(mappedBy = "areaM2")
    private Collection<Tmovear> tmovearCollection;
    @OneToMany(mappedBy = "areaM1")
    private Collection<Tmovear> tmovearCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaM")
    private Collection<AttractionM> attractionMCollection;
    @OneToMany(mappedBy = "areaM")
    private Collection<Tmoveaa> tmoveaaCollection;
    @JoinColumn(name = "MUSEUM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Museum museum;

    public AreaM() {
    }

    public AreaM(Long id) {
        this.id = id;
    }

    public AreaM(Long id, String name) {
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
    public Collection<AttractionM> getAttractionMCollection() {
        return attractionMCollection;
    }

    public void setAttractionMCollection(Collection<AttractionM> attractionMCollection) {
        this.attractionMCollection = attractionMCollection;
    }

    @XmlTransient
    public Collection<Tmoveaa> getTmoveaaCollection() {
        return tmoveaaCollection;
    }

    public void setTmoveaaCollection(Collection<Tmoveaa> tmoveaaCollection) {
        this.tmoveaaCollection = tmoveaaCollection;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
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
        if (!(object instanceof AreaM)) {
            return false;
        }
        AreaM other = (AreaM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AreaM[ id=" + id + " ]";
    }
    
}
