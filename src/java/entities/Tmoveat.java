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
@Table(name = "TMOVEAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmoveat.findAll", query = "SELECT t FROM Tmoveat t"),
    
@NamedQuery(name = "Tmoveat.findByAttractionAndMinute", query = "SELECT t FROM Tmoveat t WHERE t.attractionC1.id = :srcId and t.attractionC2.id = :destId and t.minutes = :minutes"),
@NamedQuery(name = "Tmoveat.findByAttractionMandMinute", query = "SELECT t FROM Tmoveat t WHERE t.attractionM1.id = :srcId and t.attractionM2.id = :destId and t.minutes = :minutes"),
@NamedQuery(name = "Tmoveat.findByAttractionOamAndMinute", query = "SELECT t FROM Tmoveat t WHERE t.attractionOam1.id = :srcId  and t.attractionOam2.id = :destId and t.minutes = :minutes"),

    @NamedQuery(name = "Tmoveat.findById", query = "SELECT t FROM Tmoveat t WHERE t.id = :id"),
    @NamedQuery(name = "Tmoveat.findByMinutes", query = "SELECT t FROM Tmoveat t WHERE t.minutes = :minutes")})
public class Tmoveat implements Serializable {

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
    @JoinColumn(name = "ATTRACTION_C2", referencedColumnName = "ID")
    @ManyToOne
    private AttractionC attractionC2;
    @JoinColumn(name = "ATTRACTION_C1", referencedColumnName = "ID")
    @ManyToOne
    private AttractionC attractionC1;
    @JoinColumn(name = "ATTRACTION_M2", referencedColumnName = "ID")
    @ManyToOne
    private AttractionM attractionM2;
    @JoinColumn(name = "ATTRACTION_M1", referencedColumnName = "ID")
    @ManyToOne
    private AttractionM attractionM1;
    @JoinColumn(name = "ATTRACTION_OAM2", referencedColumnName = "ID")
    @ManyToOne
    private AttractionOam attractionOam2;
    @JoinColumn(name = "ATTRACTION_OAM1", referencedColumnName = "ID")
    @ManyToOne
    private AttractionOam attractionOam1;
    @OneToMany(mappedBy = "tmoveat")
    private Collection<Sensing> sensingCollection;

    public Tmoveat() {
    }

    public Tmoveat(Long id) {
        this.id = id;
    }

    public Tmoveat(Long id, int minutes) {
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

    public AttractionC getAttractionC2() {
        return attractionC2;
    }

    public void setAttractionC2(AttractionC attractionC2) {
        this.attractionC2 = attractionC2;
    }

    public AttractionC getAttractionC1() {
        return attractionC1;
    }

    public void setAttractionC1(AttractionC attractionC1) {
        this.attractionC1 = attractionC1;
    }

    public AttractionM getAttractionM2() {
        return attractionM2;
    }

    public void setAttractionM2(AttractionM attractionM2) {
        this.attractionM2 = attractionM2;
    }

    public AttractionM getAttractionM1() {
        return attractionM1;
    }

    public void setAttractionM1(AttractionM attractionM1) {
        this.attractionM1 = attractionM1;
    }

    public AttractionOam getAttractionOam2() {
        return attractionOam2;
    }

    public void setAttractionOam2(AttractionOam attractionOam2) {
        this.attractionOam2 = attractionOam2;
    }

    public AttractionOam getAttractionOam1() {
        return attractionOam1;
    }

    public void setAttractionOam1(AttractionOam attractionOam1) {
        this.attractionOam1 = attractionOam1;
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
        if (!(object instanceof Tmoveat)) {
            return false;
        }
        Tmoveat other = (Tmoveat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tmoveat[ id=" + id + " ]";
    }
    
}
