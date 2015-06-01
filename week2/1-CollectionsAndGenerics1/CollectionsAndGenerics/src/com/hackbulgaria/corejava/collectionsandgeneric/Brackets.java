package com.hackbulgaria.corejava.collectionsandgeneric;

public class Brackets {
    public static boolean checkBrackets(String str){
        int position=0;
        int left=0, right=0;
        if(str.startsWith(")") || str.endsWith("("))
            return false;
        else {
            while(position<str.length()){
                switch (str.charAt(position)){
                    case '(':left++;break;
                    case ')':right++;break;
                } 
                if(right>left){
                    return false;
                }
                position++;
                
            }
        }
                
            
            if(left==right){
                return true;
            }
             else{
                    return false;
                }
            }
        
            
       
    

    public static void main(String[] args) {
       String str="()()()";
       System.out.println(checkBrackets(str));
       String stri=")()()()";
       System.out.println(checkBrackets(stri));
       String st="()()()(";
       System.out.println(checkBrackets(st));
       String tr="(())))()()";
       System.out.println(checkBrackets(tr));
       String r="(((())))()()";
       System.out.println(checkBrackets(r));

    }

}
