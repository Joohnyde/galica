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
public class CreateKategorijaModel implements Serializable {
    private String ime;
    private PrilogKategorija[] prilozi;
    private Integer min;
    private Integer max;

    public CreateKategorijaModel(String ime, PrilogKategorija[] prilozi, Integer min, Integer max) {
        this.ime = ime;
        this.prilozi = prilozi;
        this.min = min;
        this.max = max;
    }

    public CreateKategorijaModel() {
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public PrilogKategorija[] getPrilozi() {
        return prilozi;
    }

    public void setPrilozi(PrilogKategorija[] prilozi) {
        this.prilozi = prilozi;
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

    
    public class PrilogKategorija implements Serializable{
        private UUID postojeciPrilog;
        private CreatePrilogModel noviPrilog; 
        private Double extraCena = 0.0; 
        private Boolean podrazumevano = false;

        public PrilogKategorija(UUID postojeciPrilog, CreatePrilogModel noviPrilog) {
            this.postojeciPrilog = postojeciPrilog;
            this.noviPrilog = noviPrilog;
        }

        public PrilogKategorija() {
        }
        
        public PrilogKategorija(UUID postojeciPrilog, CreatePrilogModel noviPrilog, Double extraCena, Boolean podrazumevano) {
            this.postojeciPrilog = postojeciPrilog;
            this.noviPrilog = noviPrilog;
            this.extraCena = extraCena;
            this.podrazumevano = podrazumevano;
        }

        public UUID getPostojeciPrilog() {
            return postojeciPrilog;
        }

        public void setPostojeciPrilog(UUID postojeciPrilog) {
            this.postojeciPrilog = postojeciPrilog;
        }

        public CreatePrilogModel getNoviPrilog() {
            return noviPrilog;
        }

        public void setNoviPrilog(CreatePrilogModel noviPrilog) {
            this.noviPrilog = noviPrilog;
        }

        public Double getExtraCena() {
            return extraCena;
        }

        public void setExtraCena(Double extraCena) {
            this.extraCena = extraCena;
        }

        public Boolean getPodrazumevano() {
            return podrazumevano;
        }

        public void setPodrazumevano(Boolean podrazumevano) {
            this.podrazumevano = podrazumevano;
        }
        
        
        
    }
}
