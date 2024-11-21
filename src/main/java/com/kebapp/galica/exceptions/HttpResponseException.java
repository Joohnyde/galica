/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.exceptions;

import java.io.Serializable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author denijal
 */
public abstract class HttpResponseException extends Exception implements Serializable {
    
    private final int code;
    private final String title;
    private final String message;
    
    public final ResponseEntity response;
    
    public HttpResponseException(int code, String title, String message){
        super(message);
        this.code = code;
        this.title = title;
        this.message = message;
        
        response = ResponseEntity.status(this.code).contentType(MediaType.APPLICATION_JSON).body("{\"code\":"+this.code+",\"title\":\""+this.title+"\",\"msg\":\""+this.message+"\"}");
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
    
    public String getMsg() {
        return message;
    }
    
    @Override
    public String toString(){
        return "["+this.code+"] "+this.title+" : "+this.message;
    }    
    
    
}
