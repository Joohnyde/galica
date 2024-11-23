/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kebapp.galica.interfaces.interfaces;

import com.kebapp.galica.entities.Kategorija;
import com.kebapp.galica.exceptions.InvalidUUIDException;
import com.kebapp.galica.exceptions.MissingParameterException;
import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.models.request.CreateKategorijaModel;

/**
 *
 * @author denijal
 */
public interface KategorijaInterface {
    
    public Kategorija parseKategorija(CreateKategorijaModel model) throws SemanticException, MissingParameterException, InvalidUUIDException;
    
    public void save(Kategorija kategorija);
}
