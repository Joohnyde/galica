/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.models.request;

import com.kebapp.galica.models.utils.PrilogKategorija;
import java.io.Serializable;

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
}
