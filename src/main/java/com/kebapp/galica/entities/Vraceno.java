/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author denijal
 */
@Entity
@Table(schema = "public", name = "vraceno")
@NamedQueries({
    @NamedQuery(name = "Vraceno.findAll", query = "SELECT v FROM Vraceno v")})
public class Vraceno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private Object id;
    @Lob
    @Column(name = "sonstige")
    private Object sonstige;
    @JoinColumn(name = "narudzbinastavka_id", referencedColumnName = "id")
    @ManyToOne
    private Narudzbinastavka narudzbinastavkaId;
    @OneToMany(mappedBy = "vracenoId")
    private List<Vracenoprilog> vracenoprilogList;

    public Vraceno() {
    }

    public Vraceno(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getSonstige() {
        return sonstige;
    }

    public void setSonstige(Object sonstige) {
        this.sonstige = sonstige;
    }

    public Narudzbinastavka getNarudzbinastavkaId() {
        return narudzbinastavkaId;
    }

    public void setNarudzbinastavkaId(Narudzbinastavka narudzbinastavkaId) {
        this.narudzbinastavkaId = narudzbinastavkaId;
    }

    public List<Vracenoprilog> getVracenoprilogList() {
        return vracenoprilogList;
    }

    public void setVracenoprilogList(List<Vracenoprilog> vracenoprilogList) {
        this.vracenoprilogList = vracenoprilogList;
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
        if (!(object instanceof Vraceno)) {
            return false;
        }
        Vraceno other = (Vraceno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Vraceno[ id=" + id + " ]";
    }
    
}
