/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.exceptions;

/**
 *
 * @author denijal
 */
public class MissingParameterException extends HttpResponseException{
    
    public MissingParameterException(String message) {
        super(422, "MISSING_PARAMETER", message);
    }
    
}
