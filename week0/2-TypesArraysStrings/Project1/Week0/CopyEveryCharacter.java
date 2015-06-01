package Week0;
import java.lang.StringBuilder;
/**
 *
 * @author Desislava
 */
public class CopyEveryCharacter {
    public static String copyEveryChar(String input, int k){
        StringBuilder result= new StringBuilder();
        int j=0;
        for(int i=j;i<input.length();i++){
            for(int counter=1;counter<=k;counter++){
                result.insert(j, input.charAt(i));
                j++;
            }
        }
        return result.toString();
    }


    
     public static void main(String []args){
      System.out.println(copyEveryChar("tldr", 3));
    }  
    
}
