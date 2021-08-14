package com.learn.exception;


import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;
    
	
    private String error;
    private String message;

    public StandardError(){
        
    }

    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		
        this.error = error;
        this.message = message;

    }



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    
}