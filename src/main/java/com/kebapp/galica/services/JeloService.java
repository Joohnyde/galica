/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Jelo;
import com.kebapp.galica.entities.Kategorija;
import com.kebapp.galica.entities.Kategorijajelo;
import com.kebapp.galica.exceptions.InvalidUUIDException;
import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.interfaces.interfaces.JeloInterface;
import com.kebapp.galica.interfaces.repositories.JeloRepository;
import com.kebapp.galica.interfaces.repositories.KategorijaRepository;
import com.kebapp.galica.interfaces.repositories.KategorijajeloRepository;
import com.kebapp.galica.models.request.CreateJeloModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author denijal
 */
@Service
public class JeloService implements JeloInterface {
    
    @Autowired
    private JeloRepository JeloRepository;

    @Autowired
    private KategorijajeloRepository kategorijajeloRepository;
    
    @Autowired
    private KategorijaRepository kategorijaRepository;
    
    @Override
    public void createJelo(CreateJeloModel createJeloObject) throws SemanticException, InvalidUUIDException {
        // Креирај јело
        Jelo novoJelo = new Jelo(createJeloObject);
        
        // Додај му постојеће категорије
        if(createJeloObject.getPostojeceKategorije() != null){
            
            for(CreateJeloModel.PostojecaKategorija uuidKategorije : createJeloObject.getPostojeceKategorije()){
                
                if(uuidKategorije == null)
                    throw new InvalidUUIDException("One of the given UUIDs was null");
                /*
                    Ово враћа објекат у ком се заштићено може приступити катего-
                рији из базе. Потребно је проверити постоји ли уопште тражена
                категорија.
                */
                Optional<Kategorija> maybeKategorija = kategorijaRepository.findById(uuidKategorije);
                if(maybeKategorija.isEmpty())
                    throw new InvalidUUIDException("One of the given category UUIDs could not be found");
                
                // Увежи постојећу категорију
                Kategorijajelo novaKategorijaJelo = new Kategorijajelo();
            }
        }
        
        // Додај категорије и прилоге
        
        JeloRepository.saveAndFlush(novoJelo);
    }
    
}
