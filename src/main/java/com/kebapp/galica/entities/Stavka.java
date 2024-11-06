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
@Table(schema = "public", name = "stavka")
@NamedQueries({
    @NamedQuery(name = "Stavka.findAll", query = "SELECT s FROM Stavka s"),
    @NamedQuery(name = "Stavka.findByRbr", query = "SELECT s FROM Stavka s WHERE s.rbr = :rbr"),
    @NamedQuery(name = "Stavka.findByKolicina", query = "SELECT s FROM Stavka s WHERE s.kolicina = :kolicina")})
public class Stavka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private Object id;
    @Column(name = "rbr")
    private Integer rbr;
    @Column(name = "kolicina")
    private Integer kolicina;
    @OneToMany(mappedBy = "stavkaId")
    private List<Narudzbinastavka> narudzbinastavkaList;
    @OneToMany(mappedBy = "stavkaId")
    private List<Stavkaprilogkategorija> stavkaprilogkategorijaList;
    @JoinColumn(name = "jelo_id", referencedColumnName = "id")
    @ManyToOne
    private Jelo jeloId;

    public Stavka() {
    }

    public Stavka(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getRbr() {
        return rbr;
    }

    public void setRbr(Integer rbr) {
        this.rbr = rbr;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public List<Narudzbinastavka> getNarudzbinastavkaList() {
        return narudzbinastavkaList;
    }

    public void setNarudzbinastavkaList(List<Narudzbinastavka> narudzbinastavkaList) {
        this.narudzbinastavkaList = narudzbinastavkaList;
    }

    public List<Stavkaprilogkategorija> getStavkaprilogkategorijaList() {
        return stavkaprilogkategorijaList;
    }

    public void setStavkaprilogkategorijaList(List<Stavkaprilogkategorija> stavkaprilogkategorijaList) {
        this.stavkaprilogkategorijaList = stavkaprilogkategorijaList;
    }

    public Jelo getJeloId() {
        return jeloId;
    }

    public void setJeloId(Jelo jeloId) {
        this.jeloId = jeloId;
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
        if (!(object instanceof Stavka)) {
            return false;
        }
        Stavka other = (Stavka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Stavka[ id=" + id + " ]";
    }
    
}
