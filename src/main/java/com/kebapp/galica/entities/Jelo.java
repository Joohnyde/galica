    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.entities;

import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.models.request.CreateJeloModel;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import java.util.UUID;

/**
 *
 * @author denijal
 */
@Entity
@Table(schema = "public", name = "jelo")
@NamedQueries({
    @NamedQuery(name = "Jelo.findAll", query = "SELECT j FROM Jelo j"),
    @NamedQuery(name = "Jelo.findByIme", query = "SELECT j FROM Jelo j WHERE j.ime = :ime"),
    @NamedQuery(name = "Jelo.findByOpis", query = "SELECT j FROM Jelo j WHERE j.opis = :opis"),
    @NamedQuery(name = "Jelo.findByBasecena", query = "SELECT j FROM Jelo j WHERE j.basecena = :basecena"),
    @NamedQuery(name = "Jelo.findByBasetime", query = "SELECT j FROM Jelo j WHERE j.basetime = :basetime")})
public class Jelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private Object id;
    @Column(name = "ime")
    private String ime;
    @Column(name = "opis")
    private String opis;
    @Lob
    @Column(name = "slika")
    private byte[] slika;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "basecena")
    private Double basecena;
    @Column(name = "basetime")
    private Double basetime;
    @OneToMany(mappedBy = "jeloId")
    private List<Stavka> stavkaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jeloId")
    private List<Kategorijajelo> kategorijajeloList;

    public Jelo(CreateJeloModel model) throws SemanticException{
        
        this.basecena = model.getBaseCena();
        this.basetime = model.getBaseTime();
        
        if(this.basecena == null)
            throw new SemanticException("Base price cannot be null");
        if(this.basecena < 0 || this.basetime < 0)
            throw new SemanticException("Base price and base time must be non-negative values");
        
        this.ime = model.getIme();
        if(this.ime == null)
            throw new SemanticException("Dish name must be given");
        
        this.id = UUID.randomUUID();
        this.opis = model.getOpis();
        this.slika = model.getSlika();
    }
    
    public Jelo() {
    }

    public Jelo(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }

    public Double getBasecena() {
        return basecena;
    }

    public void setBasecena(Double basecena) {
        this.basecena = basecena;
    }

    public Double getBasetime() {
        return basetime;
    }

    public void setBasetime(Double basetime) {
        this.basetime = basetime;
    }

    public List<Stavka> getStavkaList() {
        return stavkaList;
    }

    public void setStavkaList(List<Stavka> stavkaList) {
        this.stavkaList = stavkaList;
    }

    public List<Kategorijajelo> getKategorijajeloList() {
        return kategorijajeloList;
    }

    public void setKategorijajeloList(List<Kategorijajelo> kategorijajeloList) {
        this.kategorijajeloList = kategorijajeloList;
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
        if (!(object instanceof Jelo)) {
            return false;
        }
        Jelo other = (Jelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Jelo[ id=" + id + " ]";
    }
    
}
