/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.models.request;

/**
 *
 * @author denijal
 */
public class CreatePrilogModel {
    private String ime;
    private String opis;
    private Byte[] slika;

    public CreatePrilogModel(String ime, String opis, Byte[] slika) {
        this.ime = ime;
        this.opis = opis;
        this.slika = slika;
    }

    public CreatePrilogModel() {
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
    
}
