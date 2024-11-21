/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author denijal
 */
@Entity
@Table(schema = "public", name = "narudzbina")
@NamedQueries({
    @NamedQuery(name = "Narudzbina.findAll", query = "SELECT n FROM Narudzbina n"),
    @NamedQuery(name = "Narudzbina.findByCreated", query = "SELECT n FROM Narudzbina n WHERE n.created = :created"),
    @NamedQuery(name = "Narudzbina.findByCode", query = "SELECT n FROM Narudzbina n WHERE n.code = :code"),
    @NamedQuery(name = "Narudzbina.findByEstimated", query = "SELECT n FROM Narudzbina n WHERE n.estimated = :estimated"),
    @NamedQuery(name = "Narudzbina.findByStatus", query = "SELECT n FROM Narudzbina n WHERE n.status = :status"),
    @NamedQuery(name = "Narudzbina.findByCena", query = "SELECT n FROM Narudzbina n WHERE n.cena = :cena")})
public class Narudzbina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "id")
    private UUID id;
    @Lob
    @Column(name = "covek_id")
    private Object covekId;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "code")
    private Integer code;
    @Column(name = "estimated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estimated;
    @Column(name = "status")
    private Integer status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena")
    private Double cena;
    @OneToMany(mappedBy = "narudzbinaId")
    private List<Narudzbinastavka> narudzbinastavkaList;

    public Narudzbina() {
    }

    public Narudzbina(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Object getCovekId() {
        return covekId;
    }

    public void setCovekId(Object covekId) {
        this.covekId = covekId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getEstimated() {
        return estimated;
    }

    public void setEstimated(Date estimated) {
        this.estimated = estimated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public List<Narudzbinastavka> getNarudzbinastavkaList() {
        return narudzbinastavkaList;
    }

    public void setNarudzbinastavkaList(List<Narudzbinastavka> narudzbinastavkaList) {
        this.narudzbinastavkaList = narudzbinastavkaList;
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
        if (!(object instanceof Narudzbina)) {
            return false;
        }
        Narudzbina other = (Narudzbina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kebapp.galica.entities.Narudzbina[ id=" + id + " ]";
    }
    
}
