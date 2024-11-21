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
    private byte[] slika;

    public CreatePrilogModel(String ime, String opis, byte[] slika) {
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

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }
    
}
