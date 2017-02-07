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
@Table(name = "ATTRACTION_M")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttractionM.findAll", query = "SELECT a FROM AttractionM a"),
    @NamedQuery(name = "AttractionM.findByAreaId", query = "SELECT a FROM AttractionM a WHERE a.areaM.id = :areaId"),

    @NamedQuery(name = "AttractionM.findByMuseumId", query = "SELECT a FROM AttractionM a WHERE a.areaM.museum.id = :id"),
    @NamedQuery(name = "AttractionM.findById", query = "SELECT a FROM AttractionM a WHERE a.id = :id"),
    @NamedQuery(name = "AttractionM.findByName", query = "SELECT a FROM AttractionM a WHERE a.name = :name")})
public class AttractionM implements Serializable {

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
    @OneToMany(mappedBy = "attractionM")
    private Collection<Tcoda> tcodaCollection;
    @OneToMany(mappedBy = "attractionM2")
    private Collection<Tmoveat> tmoveatCollection;
    @OneToMany(mappedBy = "attractionM1")
    private Collection<Tmoveat> tmoveatCollection1;
    @JoinColumn(name = "AREA_M", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private AreaM areaM;
    @OneToMany(mappedBy = "attractionM")
    private Collection<Tmoveaa> tmoveaaCollection;
    @OneToMany(mappedBy = "attractionM")
    private Collection<Tvisita> tvisitaCollection;

    public AttractionM() {
    }

    public AttractionM(Long id) {
        this.id = id;
    }

    public AttractionM(Long id, String name) {
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

    public AreaM getAreaM() {
        return areaM;
    }

    public void setAreaM(AreaM areaM) {
        this.areaM = areaM;
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
        if (!(object instanceof AttractionM)) {
            return false;
        }
        AttractionM other = (AttractionM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AttractionM[ id=" + id + " ]";
    }
    
}
