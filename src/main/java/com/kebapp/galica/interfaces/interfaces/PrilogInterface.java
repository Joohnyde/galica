/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kebapp.galica.interfaces.interfaces;

import com.kebapp.galica.entities.Prilog;
import com.kebapp.galica.exceptions.*;
import com.kebapp.galica.models.request.CreatePrilogModel;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author denijal
 */
public interface PrilogInterface {
    
    public Prilog parsePrilog(CreatePrilogModel model) throws MissingParameterException;
    
    public void save(Prilog prilog);
    
    public Optional<Prilog> findById(UUID uuidPrilog);
}
