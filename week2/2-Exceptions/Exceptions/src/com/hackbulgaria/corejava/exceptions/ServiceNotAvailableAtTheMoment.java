package com.hackbulgaria.corejava.exceptions;

public class ServiceNotAvailableAtTheMoment extends Exception{

    private static final long serialVersionUID = 1L;
 
    public ServiceNotAvailableAtTheMoment(){
        super();
    }
    
    public ServiceNotAvailableAtTheMoment(String message){
        super(message);
    }
    
    public ServiceNotAvailableAtTheMoment(Throwable cause){
        super(cause);
    }
   
    public ServiceNotAvailableAtTheMoment(String message, Throwable cause){
        super(message,cause);       
    }

    public static void main(String[] args) throws ServiceNotAvailableAtTheMoment {
        throw new ServiceNotAvailableAtTheMoment();

    }

}
