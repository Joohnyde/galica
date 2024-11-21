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
    private byte[] slika; 
    private Double baseCena; 
    private Double baseTime = 5.0;
    private PostojecaKategorija[] postojeceKategorije;
    private CreateKategorijaModel[] noveKategorije;

    public CreateJeloModel(String ime, String opis, byte[] slika, Double baseCena, Double baseTime, PostojecaKategorija[] postojeceKategorije, CreateKategorijaModel[] noveKategorije) {
        this.ime = ime;
        this.opis = opis;
        this.slika = slika;
        this.baseCena = baseCena;
        this.baseTime = baseTime;
        this.postojeceKategorije = postojeceKategorije;
        this.noveKategorije = noveKategorije;
    }
    
    public CreateJeloModel(String ime, String opis, byte[] slika, Double baseCena, PostojecaKategorija[] postojeceKategorije, CreateKategorijaModel[] noveKategorije) {
        this.ime = ime;
        this.opis = opis;
        this.slika = slika;
        this.baseCena = baseCena;
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

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
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

    public PostojecaKategorija[] getPostojeceKategorije() {
        return postojeceKategorije;
    }

    public void setPostojeceKategorije(PostojecaKategorija[] postojeceKategorije) {
        this.postojeceKategorije = postojeceKategorije;
    }

    public CreateKategorijaModel[] getNoveKategorije() {
        return noveKategorije;
    }

    public void setNoveKategorije(CreateKategorijaModel[] noveKategorije) {
        this.noveKategorije = noveKategorije;
    }
    
    
    public class PostojecaKategorija{
        private UUID postojeceKategorija;
        private Integer min;
        private Integer max;
        private Boolean copyMinMax = true;

        public PostojecaKategorija() {
        }
        
        public PostojecaKategorija(UUID postojeceKategorija, Integer min, Integer max, Boolean copy){
            this.postojeceKategorija = postojeceKategorija;
            this.min = min;
            this.max = max;
            this.copyMinMax = copy;
        }

        public UUID getPostojeceKategorija() {
            return postojeceKategorija;
        }

        public void setPostojeceKategorija(UUID postojeceKategorija) {
            this.postojeceKategorija = postojeceKategorija;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Boolean getCopyMinMax() {
            return copyMinMax;
        }

        public void setCopyMinMax(Boolean copyMinMax) {
            this.copyMinMax = copyMinMax;
        }
        
        
    }
    

}
