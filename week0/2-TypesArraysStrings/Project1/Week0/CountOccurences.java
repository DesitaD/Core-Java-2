package Week0;

/**
 *
 * @author Desislava
 */
public class CountOccurences {
    public static int countOcurrences(String needle, String haystack){
        return haystack.split(needle, -1).length - 1;
    }
    
    public static void main(String []args){
       System.out.println(countOcurrences("da", "daaadaadadada")); 
    }
}
