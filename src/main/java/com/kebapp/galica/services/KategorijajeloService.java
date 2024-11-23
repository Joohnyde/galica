/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Kategorijajelo;
import com.kebapp.galica.interfaces.interfaces.KategorijajeloInterface;
import com.kebapp.galica.interfaces.repositories.KategorijajeloRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author denijal
 */
@Service
public class KategorijajeloService implements KategorijajeloInterface{
    
    @Autowired
    private KategorijajeloRepository kategorijajeloRepository;

    @Override
    public void save(Kategorijajelo kategorijajelo) {
        kategorijajeloRepository.saveAndFlush(kategorijajelo);
    }

    @Override
    public Optional<Kategorijajelo> findById(UUID uuidKategorija) {
        return kategorijajeloRepository.findById(uuidKategorija);
    }
    
}
