package Week0;
import java.lang.StringBuilder;
/**
 *
 * @author Desislava
 */
public class ReverseString {
 public static String reverseMe(String argument){
     StringBuilder result= new StringBuilder(argument);
     
    return result.reverse().toString(); 
 }   
 
 public static void main(String[] args){
     String k="DesislavaDincheva";
     System.out.println(reverseMe(k));
 }
}
