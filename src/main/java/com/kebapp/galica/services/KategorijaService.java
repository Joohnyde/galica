/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Kategorija;
import com.kebapp.galica.interfaces.interfaces.KategorijaInterface;
import com.kebapp.galica.models.request.CreateKategorijaModel;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author denijal
 */
@Service
public class KategorijaService implements KategorijaInterface{

    @Override
    public Kategorija parseKategorija(CreateKategorijaModel model) {
        return new Kategorija(UUID.randomUUID());
    }
    
}
