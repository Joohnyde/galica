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
@Table(schema = "public", name = "vracenoprilog")
@NamedQueries({
    @NamedQuery(name = "Vracenoprilog.findAll", query = "SELECT v FROM Vracenoprilog v")})
public class Vracenoprilog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private Object id;
    @JoinColumn(name = "stavka_prilog_kategorija_id", referencedColumnName = "id")
    @ManyToOne
    private Stavkaprilogkategorija stavkaPrilogKategorijaId;
    @JoinColumn(name = "vraceno_id", referencedColumnName = "id")
    @ManyToOne
    private Vraceno vracenoId;

    public Vracenoprilog() {
    }

    public Vracenoprilog(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Stavkaprilogkategorija getStavkaPrilogKategorijaId() {
        return stavkaPrilogKategorijaId;
    }

    public void setStavkaPrilogKategorijaId(Stavkaprilogkategorija stavkaPrilogKategorijaId) {
        this.stavkaPrilogKategorijaId = stavkaPrilogKategorijaId;
    }

    public Vraceno getVracenoId() {
        return vracenoId;
    }

    public void setVracenoId(Vraceno vracenoId) {
        this.vracenoId = vracenoId;
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
        if (!(object instanceof Vracenoprilog)) {
            return false;
        }
        Vracenoprilog other = (Vracenoprilog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Vracenoprilog[ id=" + id + " ]";
    }
    
}
