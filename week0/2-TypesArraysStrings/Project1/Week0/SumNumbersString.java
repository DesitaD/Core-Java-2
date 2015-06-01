package Week0;
import java.util.ArrayList;
/**
 *
 * @author Desislava
 */
public class SumNumbersString {
    public static int sumOfNumbers(String input){
        String[] saparatedString;
        int j=0;
        int Position=0;
        while(Position<input.length()){ 
             if (Character.isDigit(input.charAt(Position))){    
                while (((Position+1)<input.length())&&(Character.isDigit(input.charAt(Position+1)))){
                   
                }
             }
        }
            int sum=0;
            
        return sum;
    }
    
    
     public static void main(String []args){
        System.out.println(sumOfNumbers("abc123dd34"));
        
    }
}
