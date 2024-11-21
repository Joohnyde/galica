/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Jelo;
import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.interfaces.interfaces.JeloInterface;
import com.kebapp.galica.interfaces.repositories.JeloRepository;
import com.kebapp.galica.models.request.CreateJeloModel;
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

    @Override
    public void createJelo(CreateJeloModel createJeloObject) throws SemanticException {
        Jelo novoJelo = new Jelo(createJeloObject);
        
        // Додај категорије и прилоге
        
        JeloRepository.saveAndFlush(novoJelo);
    }
    
}
