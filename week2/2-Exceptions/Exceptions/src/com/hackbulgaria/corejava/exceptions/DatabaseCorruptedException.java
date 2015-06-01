package com.hackbulgaria.corejava.exceptions;

public class DatabaseCorruptedException extends RuntimeException{
    private String username;
    
    public DatabaseCorruptedException(){
        super();
    }
    
    
    public DatabaseCorruptedException (String message){
        super(message);
    }
    
    public DatabaseCorruptedException(Throwable cause){
        super(cause);
    }
    
    public DatabaseCorruptedException(String message, Throwable cause){
        super(message,cause);
    }
    

    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override public String getMessage() {
        return super.getMessage() + " for productId :"; 
        } 
    public String getUsername() {
        return username; 
    }



    public static void main(String[] args) {
        try{
            throw new DatabaseCorruptedException("lala");
        }
        catch(DatabaseCorruptedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
