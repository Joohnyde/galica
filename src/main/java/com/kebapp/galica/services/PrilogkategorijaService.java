/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Prilogkategorija;
import com.kebapp.galica.interfaces.interfaces.PrilogkategorijaInterface;
import com.kebapp.galica.interfaces.repositories.PrilogkategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author denijal
 */
@Service
public class PrilogkategorijaService implements PrilogkategorijaInterface{
    
    @Autowired
    private PrilogkategorijaRepository prilogkategorijaRepository;

    @Override
    public void save(Prilogkategorija prilogkategorija) {
        prilogkategorijaRepository.saveAndFlush(prilogkategorija);
    }
    
}
