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
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author denijal
 */
@Entity
@Table(schema = "public", name = "kategorijajelo")
@NamedQueries({
    @NamedQuery(name = "Kategorijajelo.findAll", query = "SELECT k FROM Kategorijajelo k"),
    @NamedQuery(name = "Kategorijajelo.findByMin", query = "SELECT k FROM Kategorijajelo k WHERE k.min = :min"),
    @NamedQuery(name = "Kategorijajelo.findByMax", query = "SELECT k FROM Kategorijajelo k WHERE k.max = :max")})
public class Kategorijajelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private Object id;
    @Column(name = "min")
    private Integer min;
    @Column(name = "max")
    private Integer max;
    @JoinColumn(name = "jelo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Jelo jeloId;
    @JoinColumn(name = "kategorija_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kategorija kategorijaId;

    public Kategorijajelo() {
    }

    public Kategorijajelo(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Jelo getJeloId() {
        return jeloId;
    }

    public void setJeloId(Jelo jeloId) {
        this.jeloId = jeloId;
    }

    public Kategorija getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(Kategorija kategorijaId) {
        this.kategorijaId = kategorijaId;
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
        if (!(object instanceof Kategorijajelo)) {
            return false;
        }
        Kategorijajelo other = (Kategorijajelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Kategorijajelo[ id=" + id + " ]";
    }
    
}
