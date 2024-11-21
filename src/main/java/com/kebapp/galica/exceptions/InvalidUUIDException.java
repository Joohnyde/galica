/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.exceptions;

/**
 *
 * @author denijal
 */
public class InvalidUUIDException extends HttpResponseException{
    
     public InvalidUUIDException(String message) {
        super(422, "INVALID_UUID", message);
    }
     
}
