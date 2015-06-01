package Week0;
import java.util.Arrays;
/**
 *
 * @author Desislava
 */
public class Anagrams {
    public static boolean anagram(String A, String B){
        boolean flag=true;
        if(A.length()!=B.length()){
            flag=false;
        }
        else{
            char[] first = A.toLowerCase().toCharArray();
            char[] second = B.toLowerCase().toCharArray();
            Arrays.sort(first);
            Arrays.sort(second);
            System.out.println(first);
            System.out.println(second);
            for(int i=0;i<first.length;i++){
            if(first[i]==second[i]){
                flag=true;            
            }
            else{
               flag = false; 
               break;
            }
        }
        
    }
        return flag;
    }
    public static void main(String[] args){
        
        System.out.println(anagram("kamilka","milkaka"));
    }
}
