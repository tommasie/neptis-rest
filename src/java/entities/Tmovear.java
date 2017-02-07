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
@Table(name = "TMOVEAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmovear.findAll", query = "SELECT t FROM Tmovear t"),
    @NamedQuery(name = "Tmovear.findById", query = "SELECT t FROM Tmovear t WHERE t.id = :id"),
    @NamedQuery(name = "Tmovear.findByMinutes", query = "SELECT t FROM Tmovear t WHERE t.minutes = :minutes")})
public class Tmovear implements Serializable {

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
    @JoinColumn(name = "AREA_M2", referencedColumnName = "ID")
    @ManyToOne
    private AreaM areaM2;
    @JoinColumn(name = "AREA_M1", referencedColumnName = "ID")
    @ManyToOne
    private AreaM areaM1;
    @JoinColumn(name = "AREA_OAM2", referencedColumnName = "ID")
    @ManyToOne
    private AreaOam areaOam2;
    @JoinColumn(name = "AREA_OAM1", referencedColumnName = "ID")
    @ManyToOne
    private AreaOam areaOam1;
    @OneToMany(mappedBy = "tmovear")
    private Collection<Sensing> sensingCollection;

    public Tmovear() {
    }

    public Tmovear(Long id) {
        this.id = id;
    }

    public Tmovear(Long id, int minutes) {
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

    public AreaM getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(AreaM areaM2) {
        this.areaM2 = areaM2;
    }

    public AreaM getAreaM1() {
        return areaM1;
    }

    public void setAreaM1(AreaM areaM1) {
        this.areaM1 = areaM1;
    }

    public AreaOam getAreaOam2() {
        return areaOam2;
    }

    public void setAreaOam2(AreaOam areaOam2) {
        this.areaOam2 = areaOam2;
    }

    public AreaOam getAreaOam1() {
        return areaOam1;
    }

    public void setAreaOam1(AreaOam areaOam1) {
        this.areaOam1 = areaOam1;
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
        if (!(object instanceof Tmovear)) {
            return false;
        }
        Tmovear other = (Tmovear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tmovear[ id=" + id + " ]";
    }
    
}
