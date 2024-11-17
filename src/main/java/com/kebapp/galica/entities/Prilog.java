/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(schema = "public", name = "prilog")
@NamedQueries({
    @NamedQuery(name = "Prilog.findAll", query = "SELECT p FROM Prilog p"),
    @NamedQuery(name = "Prilog.findByDefaultime", query = "SELECT p FROM Prilog p WHERE p.defaultime = :defaultime"),
    @NamedQuery(name = "Prilog.findByOpis", query = "SELECT p FROM Prilog p WHERE p.opis = :opis")})
public class Prilog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private Object id;
    @Column(name = "defaultime")
    private String defaultime;
    @Lob
    @Column(name = "slika")
    private byte[] slika;
    @Column(name = "opis")
    private String opis;
    @OneToMany(mappedBy = "prilogId")
    private List<Prilogkategorija> prilogkategorijaList;

    public Prilog() {
    }

    public Prilog(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getDefaultime() {
        return defaultime;
    }

    public void setDefaultime(String defaultime) {
        this.defaultime = defaultime;
    }

    public List<Prilogkategorija> getPrilogkategorijaList() {
        return prilogkategorijaList;
    }

    public void setPrilogkategorijaList(List<Prilogkategorija> prilogkategorijaList) {
        this.prilogkategorijaList = prilogkategorijaList;
    }
    
    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
        if (!(object instanceof Prilog)) {
            return false;
        }
        Prilog other = (Prilog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Prilog[ id=" + id + " ]";
    }
    
}
