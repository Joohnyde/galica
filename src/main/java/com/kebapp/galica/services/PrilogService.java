/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Prilog;
import com.kebapp.galica.exceptions.MissingParameterException;
import com.kebapp.galica.interfaces.interfaces.PrilogInterface;
import com.kebapp.galica.interfaces.repositories.PrilogRepository;
import com.kebapp.galica.models.request.CreatePrilogModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author denijal
 */
@Service
public class PrilogService implements PrilogInterface {
    
    @Autowired
    private PrilogRepository prilogRepository;

    @Override
    public Prilog parsePrilog(CreatePrilogModel model) throws MissingParameterException {
        return new Prilog(model);
    }

    @Override
    public void save(Prilog prilog) {
        this.prilogRepository.saveAndFlush(prilog);
    }

    @Override
    public Optional<Prilog> findById(UUID uuidPrilog) {
        return this.prilogRepository.findById(uuidPrilog);
    }
    
}
