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
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

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
    private UUID id;
    @JoinColumn(name = "stavka_prilog_kategorija_id", referencedColumnName = "id")
    @ManyToOne
    private Stavkaprilogkategorija stavkaPrilogKategorijaId;
    @JoinColumn(name = "vraceno_id", referencedColumnName = "id")
    @ManyToOne
    private Vraceno vracenoId;

    public Vracenoprilog() {
    }

    public Vracenoprilog(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
