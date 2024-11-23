/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kebapp.galica.interfaces.repositories;

import com.kebapp.galica.entities.Prilog;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author denijal
 */
public interface PrilogRepository extends JpaRepository<Prilog, UUID>{
    
}
