/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.services;

import com.kebapp.galica.entities.Prilog;
import com.kebapp.galica.exceptions.InvalidUUIDException;
import com.kebapp.galica.exceptions.MissingParameterException;
import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.interfaces.interfaces.PrilogInterface;
import com.kebapp.galica.models.request.CreatePrilogModel;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author denijal
 */
@Service
public class PrilogService implements PrilogInterface {

    @Override
    public Prilog parsePrilog(CreatePrilogModel model) throws SemanticException, MissingParameterException, InvalidUUIDException {
        return new Prilog(UUID.randomUUID());
    }
    
}
