package Week0;
import java.lang.StringBuilder;
/**
 *
 * @author Desislava
 */
public class PalindromeAroundStar {
    public static int getPalindromeLength(String input){
        StringBuilder result= new StringBuilder();
        int counter=0;
        int i=0;
        while(input.charAt(i)!='*'){
            result.insert(i, input.charAt(i));
            i++;
        }
        String firstPart=result.reverse().toString();
        result.delete(0, result.capacity());
        int br=0;
        for(int j=input.indexOf("*")+1;j<input.length();j++){
           result.insert(br, input.charAt(j));
            br++;
        }
        System.out.println(firstPart);
        
       String secondPart=result.toString();
       System.out.println(secondPart);
       if(firstPart.length()<=secondPart.length()){
           for(int index=0;index<firstPart.length();index++){
               if(firstPart.charAt(index)==secondPart.charAt(index))
                   counter++;
           }
       }
       else {
           for(int index=0;index<secondPart.length();index++){
               if(firstPart.charAt(index)==secondPart.charAt(index))
                   counter++;
           }
           
       }
       
       
        return counter; 
    }
    
    
    public static void main(String []args){
                System.out.println(getPalindromeLength("taz*zad"));

    }
    
}
