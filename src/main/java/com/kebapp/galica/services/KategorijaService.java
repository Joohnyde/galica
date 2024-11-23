/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Kategorija;
import com.kebapp.galica.entities.Prilog;
import com.kebapp.galica.entities.Prilogkategorija;
import com.kebapp.galica.exceptions.InvalidUUIDException;
import com.kebapp.galica.exceptions.MissingParameterException;
import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.interfaces.interfaces.KategorijaInterface;
import com.kebapp.galica.interfaces.interfaces.PrilogInterface;
import com.kebapp.galica.interfaces.interfaces.PrilogkategorijaInterface;
import com.kebapp.galica.interfaces.repositories.KategorijaRepository;
import com.kebapp.galica.interfaces.repositories.PrilogRepository;
import com.kebapp.galica.models.request.CreateKategorijaModel;
import com.kebapp.galica.models.request.CreatePrilogModel;
import com.kebapp.galica.models.utils.PrilogKategorija;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author denijal
 */
@Service
public class KategorijaService implements KategorijaInterface{
    
    @Autowired
    private KategorijaRepository kategorijaRepository;
    
    @Autowired
    private PrilogInterface prilogInterface;   
    
    @Autowired
    private PrilogkategorijaInterface prilogkategorijaInterface;
    
    @Override
    public Kategorija parseKategorija(CreateKategorijaModel model) throws SemanticException, MissingParameterException, InvalidUUIDException {
        
        Kategorija novaKategorija = new Kategorija(model);
        
        for(int i = 0; i<model.getPrilozi().length;i++){
            PrilogKategorija prilogKat = model.getPrilozi()[i];
            if(prilogKat == null)
                throw new SemanticException("An item cannot be null");
            Double extraCena = prilogKat.getExtraCena();
            if(extraCena != null && extraCena < 0.0)
                throw new SemanticException("Extra price cannot be negative");
            Prilog noviPrilog = null;
            UUID postojeciPrilog = prilogKat.getPostojeciPrilog();
            if(postojeciPrilog != null){
                Optional<Prilog> findById = prilogInterface.findById(postojeciPrilog);
                if(findById.isEmpty())
                    throw new InvalidUUIDException("Non-existant item was given");
                noviPrilog = findById.get();
            }
            
            CreatePrilogModel noviPrilogModel = prilogKat.getNoviPrilog();
            if(noviPrilogModel != null){
                if(noviPrilog != null)
                    throw new SemanticException("You cannot add an existing item and create an item with the same model.");
                noviPrilog = prilogInterface.parsePrilog(noviPrilogModel);
            }
            
            if(noviPrilog == null)
                throw new MissingParameterException("Couldn't create or add item #"+i);
            
            Prilogkategorija novaPK = new Prilogkategorija();
            novaPK.setId(UUID.randomUUID());
            novaPK.setPrilogId(noviPrilog);
            novaPK.setKategorijaId(novaKategorija); // Mozda ovo ne mora!
            novaPK.setExtracena(extraCena);
            novaPK.setDefaultselected(prilogKat.getPodrazumevano());
            
            novaKategorija.getPrilogkategorijaList().add(novaPK);
        }
        
        return novaKategorija;
    }

    @Override
    public void save(Kategorija kategorija) {
        for(Prilogkategorija prilogKategorija : kategorija.getPrilogkategorijaList()){
            prilogInterface.save(prilogKategorija.getPrilogId());
            this.prilogkategorijaInterface.save(prilogKategorija);
        }
        this.kategorijaRepository.saveAndFlush(kategorija);
    }
    
}
