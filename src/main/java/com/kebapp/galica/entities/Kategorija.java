/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.entities;

import com.kebapp.galica.exceptions.MissingParameterException;
import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.models.request.CreateKategorijaModel;
import com.kebapp.galica.models.utils.PrilogKategorija;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author denijal
 */
@Entity
@Table(schema = "public", name = "kategorija")
@NamedQueries({
    @NamedQuery(name = "Kategorija.findAll", query = "SELECT k FROM Kategorija k"),
    @NamedQuery(name = "Kategorija.findByDefaultime", query = "SELECT k FROM Kategorija k WHERE k.defaultime = :defaultime")})
public class Kategorija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private UUID id;
    @Column(name = "defaultime")
    private String defaultime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorijaId")
    private List<Kategorijajelo> kategorijajeloList;
    @OneToMany(mappedBy = "kategorijaId")
    private List<Prilogkategorija> prilogkategorijaList;

    public Kategorija() {
    }

    public Kategorija(UUID id) {
        this.id = id;
    }

    public Kategorija(CreateKategorijaModel model) throws MissingParameterException, SemanticException {
        if(model == null) 
            throw new MissingParameterException("Model cannot be null");
        String ime = model.getIme();
        Integer max = model.getMax();
        Integer min = model.getMin();
        PrilogKategorija[] prilozi = model.getPrilozi();
        if(ime == null || ime.isBlank())
            throw new MissingParameterException("Category name must be given");
        if(max != null && max < 0 || min != null && min < 0 || min != null && max != null && min > max)
            throw new SemanticException("min and max must satisfy : 0 <= min <= max");
        if(prilozi == null || prilozi.length == 0)
            throw new MissingParameterException("A category must have at least one item");
        
        this.defaultime = ime;
        this.id = UUID.randomUUID();
        this.prilogkategorijaList = new LinkedList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDefaultime() {
        return defaultime;
    }

    public void setDefaultime(String defaultime) {
        this.defaultime = defaultime;
    }

    public List<Kategorijajelo> getKategorijajeloList() {
        return kategorijajeloList;
    }

    public void setKategorijajeloList(List<Kategorijajelo> kategorijajeloList) {
        this.kategorijajeloList = kategorijajeloList;
    }

    public List<Prilogkategorija> getPrilogkategorijaList() {
        return prilogkategorijaList;
    }
    
    public void setPrilogkategorijaList(List<Prilogkategorija> prilogkategorijaList) {
        this.prilogkategorijaList = prilogkategorijaList;
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
        if (!(object instanceof Kategorija)) {
            return false;
        }
        Kategorija other = (Kategorija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Kategorija[ id=" + id + " ]";
    }
    
}
