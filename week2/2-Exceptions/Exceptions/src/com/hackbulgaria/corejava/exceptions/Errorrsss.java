package com.hackbulgaria.corejava.exceptions;

import javax.management.RuntimeErrorException;

public class Errorrsss {
    
    public static int tryCatchFin(){
        try{
            throw new RuntimeException("My exception");
        }
        catch(RuntimeErrorException e){
            System.out.println(e.getMessage());
            return 0;
        }
        finally{
            System.out.println("finally");
           
        }
    }

    public static void main(String[] args) {
        try{
            throw new Error("My error");
            
        }
        catch (Error e){
            System.out.println(e.getMessage());
        }

    }

}
