/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tesi
 */
@Entity
@Table(name = "SENSING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensing.findAll", query = "SELECT s FROM Sensing s"),
    @NamedQuery(name = "Sensing.findById", query = "SELECT s FROM Sensing s WHERE s.id = :id"),
    @NamedQuery(name = "Sensing.findByData", query = "SELECT s FROM Sensing s WHERE s.data = :data")})
public class Sensing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "TCODA", referencedColumnName = "ID")
    @ManyToOne
    private Tcoda tcoda;
    @JoinColumn(name = "TMOVEAA", referencedColumnName = "ID")
    @ManyToOne
    private Tmoveaa tmoveaa;
    @JoinColumn(name = "TMOVEAR", referencedColumnName = "ID")
    @ManyToOne
    private Tmovear tmovear;
    @JoinColumn(name = "TMOVEAT", referencedColumnName = "ID")
    @ManyToOne
    private Tmoveat tmoveat;
    @JoinColumn(name = "TVISITA", referencedColumnName = "ID")
    @ManyToOne
    private Tvisita tvisita;

    public Sensing() {
    }

    public Sensing(Long id) {
        this.id = id;
    }

    public Sensing(Long id, Date data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tcoda getTcoda() {
        return tcoda;
    }

    public void setTcoda(Tcoda tcoda) {
        this.tcoda = tcoda;
    }

    public Tmoveaa getTmoveaa() {
        return tmoveaa;
    }

    public void setTmoveaa(Tmoveaa tmoveaa) {
        this.tmoveaa = tmoveaa;
    }

    public Tmovear getTmovear() {
        return tmovear;
    }

    public void setTmovear(Tmovear tmovear) {
        this.tmovear = tmovear;
    }

    public Tmoveat getTmoveat() {
        return tmoveat;
    }

    public void setTmoveat(Tmoveat tmoveat) {
        this.tmoveat = tmoveat;
    }

    public Tvisita getTvisita() {
        return tvisita;
    }

    public void setTvisita(Tvisita tvisita) {
        this.tvisita = tvisita;
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
        if (!(object instanceof Sensing)) {
            return false;
        }
        Sensing other = (Sensing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sensing[ id=" + id + " ]";
    }
    
}
