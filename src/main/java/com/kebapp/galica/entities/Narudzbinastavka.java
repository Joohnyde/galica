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
@Table(schema = "public", name = "narudzbinastavka")
@NamedQueries({
    @NamedQuery(name = "Narudzbinastavka.findAll", query = "SELECT n FROM Narudzbinastavka n")})
public class Narudzbinastavka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private UUID id;
    @JoinColumn(name = "narudzbina_id", referencedColumnName = "id")
    @ManyToOne
    private Narudzbina narudzbinaId;
    @JoinColumn(name = "stavka_id", referencedColumnName = "id")
    @ManyToOne
    private Stavka stavkaId;
    @OneToMany(mappedBy = "narudzbinastavkaId")
    private List<Vraceno> vracenoList;

    public Narudzbinastavka() {
    }

    public Narudzbinastavka(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Narudzbina getNarudzbinaId() {
        return narudzbinaId;
    }

    public void setNarudzbinaId(Narudzbina narudzbinaId) {
        this.narudzbinaId = narudzbinaId;
    }

    public Stavka getStavkaId() {
        return stavkaId;
    }

    public void setStavkaId(Stavka stavkaId) {
        this.stavkaId = stavkaId;
    }

    public List<Vraceno> getVracenoList() {
        return vracenoList;
    }

    public void setVracenoList(List<Vraceno> vracenoList) {
        this.vracenoList = vracenoList;
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
        if (!(object instanceof Narudzbinastavka)) {
            return false;
        }
        Narudzbinastavka other = (Narudzbinastavka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Narudzbinastavka[ id=" + id + " ]";
    }
    
}
