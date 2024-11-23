/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.entities;

import com.kebapp.galica.exceptions.MissingParameterException;
import com.kebapp.galica.models.request.CreatePrilogModel;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Types;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;

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
    private UUID id;
    @Column(name = "defaultime")
    private String defaultime;
    @JdbcTypeCode(Types.BINARY)
    @Column(name = "slika")
    private byte[] slika;
    @Column(name = "opis")
    private String opis;
    @OneToMany(mappedBy = "prilogId")
    private List<Prilogkategorija> prilogkategorijaList;

    public Prilog() {
    }

    public Prilog(UUID id) {
        this.id = id;
    }

    public Prilog(CreatePrilogModel model) throws MissingParameterException{
        if(model == null)
            throw new MissingParameterException("Model was null");
        String ime = model.getIme();
        if(ime == null || ime.isBlank())
            throw new MissingParameterException("Item name must be given");
        this.defaultime = ime;
        this.id = UUID.randomUUID();
        this.opis = model.getOpis();
        this.slika = model.getSlika();
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
