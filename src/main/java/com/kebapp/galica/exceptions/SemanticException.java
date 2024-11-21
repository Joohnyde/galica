/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.exceptions;

/**
 *
 * @author denijal
 */
public class SemanticException extends HttpResponseException{
    
    public SemanticException(String message) {
        super(400, "INVALID_SEMANTIC", message);
    }
    
}
