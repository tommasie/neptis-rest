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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tesi
 */
@Entity
@Table(name = "TMOVEAA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmoveaa.findAll", query = "SELECT t FROM Tmoveaa t"),
    @NamedQuery(name = "Tmoveaa.findById", query = "SELECT t FROM Tmoveaa t WHERE t.id = :id"),
    @NamedQuery(name = "Tmoveaa.findByMinutes", query = "SELECT t FROM Tmoveaa t WHERE t.minutes = :minutes")})
public class Tmoveaa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINUTES")
    private int minutes;
    @JoinColumn(name = "AREA_M", referencedColumnName = "ID")
    @ManyToOne
    private AreaM areaM;
    @JoinColumn(name = "AREA_OAM", referencedColumnName = "ID")
    @ManyToOne
    private AreaOam areaOam;
    @JoinColumn(name = "ATTRACTION_C", referencedColumnName = "ID")
    @ManyToOne
    private AttractionC attractionC;
    @JoinColumn(name = "ATTRACTION_M", referencedColumnName = "ID")
    @ManyToOne
    private AttractionM attractionM;
    @JoinColumn(name = "ATTRACTION_OAM", referencedColumnName = "ID")
    @ManyToOne
    private AttractionOam attractionOam;
    @OneToMany(mappedBy = "tmoveaa")
    private Collection<Sensing> sensingCollection;

    public Tmoveaa() {
    }

    public Tmoveaa(Long id) {
        this.id = id;
    }

    public Tmoveaa(Long id, int minutes) {
        this.id = id;
        this.minutes = minutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public AreaM getAreaM() {
        return areaM;
    }

    public void setAreaM(AreaM areaM) {
        this.areaM = areaM;
    }

    public AreaOam getAreaOam() {
        return areaOam;
    }

    public void setAreaOam(AreaOam areaOam) {
        this.areaOam = areaOam;
    }

    public AttractionC getAttractionC() {
        return attractionC;
    }

    public void setAttractionC(AttractionC attractionC) {
        this.attractionC = attractionC;
    }

    public AttractionM getAttractionM() {
        return attractionM;
    }

    public void setAttractionM(AttractionM attractionM) {
        this.attractionM = attractionM;
    }

    public AttractionOam getAttractionOam() {
        return attractionOam;
    }

    public void setAttractionOam(AttractionOam attractionOam) {
        this.attractionOam = attractionOam;
    }

    @XmlTransient
    public Collection<Sensing> getSensingCollection() {
        return sensingCollection;
    }

    public void setSensingCollection(Collection<Sensing> sensingCollection) {
        this.sensingCollection = sensingCollection;
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
        if (!(object instanceof Tmoveaa)) {
            return false;
        }
        Tmoveaa other = (Tmoveaa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tmoveaa[ id=" + id + " ]";
    }
    
}
