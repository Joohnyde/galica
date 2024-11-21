/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kebapp.galica.interfaces.interfaces;

import com.kebapp.galica.exceptions.SemanticException;
import com.kebapp.galica.models.request.CreateJeloModel;

/**
 *
 * @author denijal
 */
public interface JeloInterface {
    
    public void createJelo(CreateJeloModel createJeloObject) throws SemanticException;
    
}
