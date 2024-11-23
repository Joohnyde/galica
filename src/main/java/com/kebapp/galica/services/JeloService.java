/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Jelo;
import com.kebapp.galica.entities.Kategorija;
import com.kebapp.galica.entities.Kategorijajelo;
import com.kebapp.galica.exceptions.InvalidUUIDException;
import com.kebapp.galica.exceptions.MissingParameterException;
import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.interfaces.interfaces.JeloInterface;
import com.kebapp.galica.interfaces.interfaces.KategorijaInterface;
import com.kebapp.galica.interfaces.interfaces.KategorijajeloInterface;
import com.kebapp.galica.interfaces.repositories.JeloRepository;
import com.kebapp.galica.models.request.CreateJeloModel;
import com.kebapp.galica.models.request.CreateKategorijaModel;
import com.kebapp.galica.models.utils.PostojecaKategorija;
import java.util.LinkedList;
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
    private JeloRepository jeloRepository;

    @Autowired
    private KategorijajeloInterface kategorijajeloInterface;
    
    @Autowired
    private KategorijaInterface kategorijaInterface;
    
    @Override
    public UUID createJelo(CreateJeloModel createJeloObject) throws SemanticException, InvalidUUIDException, MissingParameterException {
        // Креирај јело
        Jelo novoJelo = new Jelo(createJeloObject);
        
        LinkedList<Kategorijajelo> listaKategorija = new LinkedList<>();
        
        // Додај му постојеће категорије
        if(createJeloObject.getPostojeceKategorije() != null){
            
            for(PostojecaKategorija postojecaKategorija : createJeloObject.getPostojeceKategorije()){
                
                if(postojecaKategorija == null) 
                    throw new SemanticException("One of the given categories is null");
                
                Integer max = postojecaKategorija.getMax();
                Integer min = postojecaKategorija.getMin();
                if(!postojecaKategorija.getCopyMinMax()){
                    if(max != null && max < 0 || min != null && min < 0 || max != null && min != null && min > max)
                        throw new SemanticException("min and max must satisfy : 0 <= min <= max");
                }
                
                UUID uuidKategorija = postojecaKategorija.getPostojeceKategorija();
                
                if(uuidKategorija == null)
                    throw new InvalidUUIDException("One of the given UUIDs was null");
                /*
                    Ово враћа објекат у ком се заштићено може приступити катего-
                рији из базе. Потребно је проверити постоји ли уопште тражена
                категорија.
                */
                Optional<Kategorijajelo> maybeKategorija = kategorijajeloInterface.findById(uuidKategorija);
                if(maybeKategorija.isEmpty())
                    throw new InvalidUUIDException("One of the given category UUIDs could not be found");
                
                // Увежи постојећу категорију
                Kategorijajelo novaKategorijaJelo = new Kategorijajelo(novoJelo, 
                                                                       maybeKategorija.get().getKategorijaId(),
                                                                       postojecaKategorija.getCopyMinMax() ? maybeKategorija.get().getMax() : max,
                                                                       postojecaKategorija.getCopyMinMax() ? maybeKategorija.get().getMin() : min);
                listaKategorija.add(novaKategorijaJelo);
            }
        }
        
        // Креирање нове категорије
        if(createJeloObject.getNoveKategorije() != null){
            for(CreateKategorijaModel novaKategorijaModel : createJeloObject.getNoveKategorije()){
                
                // Основне провере
                if(novaKategorijaModel == null) 
                    throw new SemanticException("One of the given categories is null");
                
                Integer max = novaKategorijaModel.getMax();
                Integer min = novaKategorijaModel.getMin();
                if(max != null && max < 0 || min != null && min < 0 || max != null && min != null && min > max)
                    throw new SemanticException("min and max must satisfy : 0 <= min <= max");
                
                // Пусти даљу обраду функцији која обрађује креирање категорија
                Kategorija novaKategorija = kategorijaInterface.parseKategorija(novaKategorijaModel);
                
                // Претходна функција није бацила грешку - Додај нову категорију
                Kategorijajelo novaKategorijaJelo = new Kategorijajelo(novoJelo, novaKategorija, min, max);
                listaKategorija.add(novaKategorijaJelo);
            }
        }
        
        // Све је прошло да ваља - ручно каскадно сачувај све објекте
        
        jeloRepository.saveAndFlush(novoJelo);
        
        for(Kategorijajelo kategorijaJelo : listaKategorija){
            kategorijaInterface.save(kategorijaJelo.getKategorijaId());
            kategorijajeloInterface.save(kategorijaJelo);
        }
        
        return (UUID) novoJelo.getId();
    }
    
}
