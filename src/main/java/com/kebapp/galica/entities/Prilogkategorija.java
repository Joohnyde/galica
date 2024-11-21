/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author denijal
 */
@Entity
@Table(schema = "public", name = "prilogkategorija")
@NamedQueries({
    @NamedQuery(name = "Prilogkategorija.findAll", query = "SELECT p FROM Prilogkategorija p"),
    @NamedQuery(name = "Prilogkategorija.findByDefaultselected", query = "SELECT p FROM Prilogkategorija p WHERE p.defaultselected = :defaultselected"),
    @NamedQuery(name = "Prilogkategorija.findByExtracena", query = "SELECT p FROM Prilogkategorija p WHERE p.extracena = :extracena")})
public class Prilogkategorija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private UUID id;
    @Column(name = "defaultselected")
    private Boolean defaultselected;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "extracena")
    private Double extracena;
    @OneToMany(mappedBy = "prilogkategorijaId")
    private List<Stavkaprilogkategorija> stavkaprilogkategorijaList;
    @JoinColumn(name = "kategorija_id", referencedColumnName = "id")
    @ManyToOne
    private Kategorija kategorijaId;
    @JoinColumn(name = "prilog_id", referencedColumnName = "id")
    @ManyToOne
    private Prilog prilogId;

    public Prilogkategorija() {
    }

    public Prilogkategorija(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getDefaultselected() {
        return defaultselected;
    }

    public void setDefaultselected(Boolean defaultselected) {
        this.defaultselected = defaultselected;
    }

    public Double getExtracena() {
        return extracena;
    }

    public void setExtracena(Double extracena) {
        this.extracena = extracena;
    }

    public List<Stavkaprilogkategorija> getStavkaprilogkategorijaList() {
        return stavkaprilogkategorijaList;
    }

    public void setStavkaprilogkategorijaList(List<Stavkaprilogkategorija> stavkaprilogkategorijaList) {
        this.stavkaprilogkategorijaList = stavkaprilogkategorijaList;
    }

    public Kategorija getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(Kategorija kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    public Prilog getPrilogId() {
        return prilogId;
    }

    public void setPrilogId(Prilog prilogId) {
        this.prilogId = prilogId;
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
        if (!(object instanceof Prilogkategorija)) {
            return false;
        }
        Prilogkategorija other = (Prilogkategorija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Prilogkategorija[ id=" + id + " ]";
    }
    
}
