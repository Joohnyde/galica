/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.models.request;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author denijal
 */
public class CreateJeloModel implements Serializable{
    private String ime;
    private String opis; 
    private Byte[] slika; 
    private Double baseCena; 
    private Double baseTime;
    private UUID[] postojeceKategorije;
    private CreateKategorijaModel[] noveKategorije;

    public CreateJeloModel(String ime, String opis, Byte[] slika, Double baseCena, Double baseTime, UUID[] postojeceKategorije, CreateKategorijaModel[] noveKategorije) {
        this.ime = ime;
        this.opis = opis;
        this.slika = slika;
        this.baseCena = baseCena;
        this.baseTime = baseTime;
        this.postojeceKategorije = postojeceKategorije;
        this.noveKategorije = noveKategorije;
    }

    public CreateJeloModel() {
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

    public Byte[] getSlika() {
        return slika;
    }

    public void setSlika(Byte[] slika) {
        this.slika = slika;
    }

    public Double getBaseCena() {
        return baseCena;
    }

    public void setBaseCena(Double baseCena) {
        this.baseCena = baseCena;
    }

    public Double getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(Double baseTime) {
        this.baseTime = baseTime;
    }

    public UUID[] getPostojeceKategorije() {
        return postojeceKategorije;
    }

    public void setPostojeceKategorije(UUID[] postojeceKategorije) {
        this.postojeceKategorije = postojeceKategorije;
    }

    public CreateKategorijaModel[] getNoveKategorije() {
        return noveKategorije;
    }

    public void setNoveKategorije(CreateKategorijaModel[] noveKategorije) {
        this.noveKategorije = noveKategorije;
    }
    
    

}
