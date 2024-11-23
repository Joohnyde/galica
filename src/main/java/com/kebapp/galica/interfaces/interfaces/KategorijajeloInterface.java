/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kebapp.galica.interfaces.interfaces;

import com.kebapp.galica.entities.Kategorijajelo;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author denijal
 */
public interface KategorijajeloInterface {    

    public void save(Kategorijajelo kategorijajelo);
    
    public Optional<Kategorijajelo> findById(UUID uuidKategorija);
    
}
